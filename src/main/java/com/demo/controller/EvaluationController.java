package com.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.entity.evaluation.EvaluationCriteria;
import com.demo.entity.evaluation.EvaluationCriteriaExample;
import com.demo.entity.financ.financProduct;
import com.demo.entity.sys.SysUser;
import com.demo.service.evaluation.EvaluationService;
import com.demo.service.finance.FinanceService;
import com.demo.service.sys.SysService;
import com.demo.service.sys.UserService;
import com.demo.util.ServletApplicationObject;
import com.demo.util.StringUtil;

import oracle.net.aso.c;

@Controller
@RequestMapping("evaluation")
public class EvaluationController {
	
	@Resource
	private FinanceService financeService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private EvaluationService evaluationService ;
	
	@Resource
	private SysService sysService;
	
	@RequestMapping("evaluation.html")
	public String evaluationHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			setUserName(fp);
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "evaluation/editEvaluation";
	}
	
	@RequestMapping("evaluationLoan.json")
	public String evaluationLoanJson(HttpServletRequest request , String evaluationScore , String id){
		EvaluationCriteria ec=new EvaluationCriteria();
		SysUser user = ServletApplicationObject.getUser(request);
		ec.setEvaluationScore(new BigDecimal(evaluationScore));
		ec.setEvaluatorsMan(user.getId().toString());
		ec.setId(sysService.findId());
		ec.setFid(new BigDecimal(id.trim()));
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id.trim()));
			ec.setValuationMan(fp.getPublicMan().toString());
			evaluationService.insert(ec);
			if(ec.getEvaluationScore().intValue()==5){
				user.setCreditRate(new BigDecimal(user.getCreditRate()).add(new BigDecimal(1)).toString());
			}else if (ec.getEvaluationScore().intValue()<=1 && ec.getEvaluationScore().intValue()>0){
				user.setCreditRate(new BigDecimal(user.getCreditRate()).subtract(new BigDecimal(1)).toString());
			}else if(ec.getEvaluationScore().intValue()==0){
				user.setCreditRate(new BigDecimal(user.getCreditRate()).subtract(new BigDecimal(2)).toString());
			}
			EvaluationCriteriaExample example = new EvaluationCriteriaExample();
			EvaluationCriteriaExample.Criteria criteria = example.createCriteria();
			criteria.andFidEqualTo(new BigDecimal(id.trim()));
			List<EvaluationCriteria > list = evaluationService.selectByExample(example);
			if(list.size()==2){
				fp.setState("7");
				financeService.updateByPrimaryKeySelective(fp);
			}else{
				fp.setState("10");
				financeService.updateByPrimaryKeySelective(fp);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:../loan/myLoan.html";
	}
	
	@RequestMapping("evaluation.json")
	public String evaluationJson(HttpServletRequest request , String evaluationScore , String id){
		EvaluationCriteria ec=new EvaluationCriteria();
		SysUser user = ServletApplicationObject.getUser(request);
		ec.setEvaluationScore(new BigDecimal(evaluationScore));
		ec.setEvaluatorsMan(user.getId().toString());
		ec.setId(sysService.findId());
		ec.setFid(new BigDecimal(id.trim()));
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id.trim()));
			ec.setValuationMan(fp.getRepaymentMan().toString());
			evaluationService.insert(ec);
			
			EvaluationCriteriaExample example = new EvaluationCriteriaExample();
			EvaluationCriteriaExample.Criteria criteria = example.createCriteria();
			criteria.andFidEqualTo(new BigDecimal(id.trim()));
			List<EvaluationCriteria > list = evaluationService.selectByExample(example);
			if(list.size()==2){
				fp.setState("7");
				financeService.updateByPrimaryKeySelective(fp);
			}else{
				fp.setState("9");
				financeService.updateByPrimaryKeySelective(fp);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:../finance/myFinance.html";
	}
	
	@RequestMapping("checkevaluation")
	@ResponseBody
	public String checkevaluation(HttpServletRequest request , String id){
		SysUser user = ServletApplicationObject.getUser(request);
		EvaluationCriteriaExample example = new EvaluationCriteriaExample();
		EvaluationCriteriaExample.Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(new BigDecimal(id.trim()));
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id.trim()));
			if(!fp.getState().equals("6")){
				return "false2";
			}
			List<EvaluationCriteria > list = evaluationService.selectByExample(example);
			for(EvaluationCriteria ec : list){
				if(ec.getEvaluatorsMan().equals(user.getId().toString())){
					return "true";
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "false";
	}
	/**
	 * 
	  * 获取发布人和贷款人的名字
	  *@param fp
	  *@throws DaoException 
	  *@date 2017年2月22日 上午5:36:57
	  *@author zxn
	 */
	private void setUserName(financProduct fp) throws DaoException{
		try {
			SysUser user1 = userService.selectByPrimaryKey(new BigDecimal(fp.getPublicMan()));
			if(user1.getRealName()!=null){
				fp.setPublicManStr(user1.getRealName());
			}else{
				fp.setPublicManStr(user1.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(StringUtil.isNotEmpty(fp.getRepaymentMan())){
				SysUser user2 = userService.selectByPrimaryKey(new BigDecimal(fp.getRepaymentMan()));
				if(user2.getRealName()!=null){
					fp.setRepaymentManStr(user2.getRealName());
				}else{
					fp.setRepaymentManStr(user2.getUserName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	  * 获取List中发布人和贷款人的名字
	  *@param list
	  *@throws DaoException 
	  *@date 2017年2月22日 上午5:37:34
	  *@author zxn
	 */
	private void setUserName(List<financProduct> list) throws DaoException{
		for(int i=0;i<list.size();i++){
			try {
				SysUser user1 = userService.selectByPrimaryKey(new BigDecimal(list.get(i).getPublicMan()));
				if(user1.getRealName()!=null){
					list.get(i).setPublicManStr(user1.getRealName());
				}else{
					list.get(i).setPublicManStr(user1.getUserName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(StringUtil.isNotEmpty(list.get(i).getRepaymentMan())){
					SysUser user2 = userService.selectByPrimaryKey(new BigDecimal(list.get(i).getRepaymentMan()));
					if(user2.getRealName()!=null){
						list.get(i).setRepaymentManStr(user2.getRealName());
					}else{
						list.get(i).setRepaymentManStr(user2.getUserName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
