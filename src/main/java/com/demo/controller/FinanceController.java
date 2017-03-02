package com.demo.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.entity.cash.CashFlow;
import com.demo.entity.financ.financProduct;
import com.demo.entity.financ.financProductExample;
import com.demo.entity.sys.SysUser;
import com.demo.service.cash.CashService;
import com.demo.service.finance.FinanceService;
import com.demo.service.sys.SysService;
import com.demo.service.sys.UserService;
import com.demo.util.DateUtil;
import com.demo.util.ServletApplicationObject;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("finance")
public class FinanceController {
	
	@Resource
	private FinanceService financeService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CashService cashService;
	
	@Resource
	private SysService sysService;
	
	@RequestMapping("myFinance.html")
	public String myFinanceHtml(){
		return "finance/myFinance";
	}
	
	@RequestMapping("myFinanceList")
	@ResponseBody
	public Map<String, Object> getMyFinanceList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		criteria.andPublicManEqualTo(user.getId().toString());
//		criteria.andPublicTypeEqualTo("1");
		if(StringUtil.isNotEmpty(loanAmount1)){
		    criteria.andLoanAmountGreaterThan(new BigDecimal(loanAmount1));
		}
		if(StringUtil.isNotEmpty(loanAmount2)){
		    criteria.andLoanAmountLessThan(new BigDecimal(loanAmount2));
		}
		if(StringUtil.isNotEmpty(interestRate1)){
		    criteria.andInterestRateGreaterThan(new BigDecimal(interestRate1));
		}
		if(StringUtil.isNotEmpty(interestRate2)){
		    criteria.andInterestRateLessThan(new BigDecimal(interestRate2));
		}
		if(StringUtil.isNotEmpty(repaymentDate1)){
			criteria.andRepaymentDateGreaterThanOrEqualTo(DateUtil.getSqlDate(repaymentDate1, "yyyy-MM-dd"));
		}
		if(StringUtil.isNotEmpty(repaymentDate2)){
			criteria.andRepaymentDateLessThanOrEqualTo(DateUtil.getSqlDate(repaymentDate2, "yyyy-MM-dd"));
		}
		try {
			List<financProduct> list = financeService.selectByExample(example);
			setUserName(list);
			Integer count = financeService.countByExample(example);
			map.put("rows",list);
			map.put("total",count);
			return map;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("newFinance.html")
	public String newFinanceHtml(){
		return "finance/newFinance";
	}
	@RequestMapping("addFinance.json")
	public String addFinanceHtml(HttpServletRequest request, financProduct fp, String repaymentDateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			fp.setRepaymentDate(sdf.parse(repaymentDateStr));
			fp.setPublicMan(user.getId().toString());
			fp.setPublicType("1");
			fp.setState("1");
			fp.setCreateDate(DateUtil.getDateByStr(DateUtil.getDate(0)));
			financeService.insertSelective(fp);
			if(fp.getLoanAmount().doubleValue()>50000){
				user.setCreditRate(new BigDecimal(user.getCreditRate()).add(new BigDecimal(1)).toString());
				userService.updateByPrimaryKey(user);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:myFinance.html";
	}
	
	@RequestMapping("editFinance.html")
	public String editFinanceHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "finance/editFinance";
	}
	
	@RequestMapping("editFinance.json")
	public String editFinanceHtml(HttpServletRequest request, financProduct fp, String repaymentDateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			fp.setRepaymentDate(sdf.parse(repaymentDateStr));
			financeService.updateByPrimaryKeySelective(fp);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:myFinance.html";
	}
	
	@RequestMapping("allFinance.html")
	public String allFinanceHtml(){
		return "finance/allFinance";
	}
	
	@RequestMapping("allFinanceList")
	@ResponseBody
	public Map<String, Object> getAllFinanceList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		criteria.andPublicTypeEqualTo("1");
		criteria.andRepaymentManIsNull();
		criteria.andPublicManNotEqualTo(user.getId().toString());
		if(StringUtil.isNotEmpty(loanAmount1)){
		    criteria.andLoanAmountGreaterThan(new BigDecimal(loanAmount1));
		}
		if(StringUtil.isNotEmpty(loanAmount2)){
		    criteria.andLoanAmountLessThan(new BigDecimal(loanAmount2));
		}
		if(StringUtil.isNotEmpty(interestRate1)){
		    criteria.andInterestRateGreaterThan(new BigDecimal(interestRate1));
		}
		if(StringUtil.isNotEmpty(interestRate2)){
		    criteria.andInterestRateLessThan(new BigDecimal(interestRate2));
		}
		if(StringUtil.isNotEmpty(repaymentDate1)){
			criteria.andRepaymentDateGreaterThanOrEqualTo(DateUtil.getSqlDate(repaymentDate1, "yyyy-MM-dd"));
		}
		if(StringUtil.isNotEmpty(repaymentDate2)){
			criteria.andRepaymentDateLessThanOrEqualTo(DateUtil.getSqlDate(repaymentDate2, "yyyy-MM-dd"));
		}
		try {
			List<financProduct> list = financeService.selectByExample(example);
			setUserName(list);
			Integer count = financeService.countByExample(example);
			map.put("rows",list);
			map.put("total",count);
			return map;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("checkLoan")
	@ResponseBody
	public Map<String, Object> checkLoan(String id){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			SysUser user = userService.selectByPrimaryKey(new BigDecimal(fp.getRepaymentMan()));
			map.put("creditRate", user.getCreditRate());
			map.put("state", fp.getState());
			map.put("sum", fp.getInterestRate().divide(new BigDecimal(100)).multiply(fp.getLoanAmount()).add(fp.getLoanAmount()).setScale(0, BigDecimal.ROUND_HALF_UP));
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			map.put("state","0");
		}
		return map;
	}
	@RequestMapping("acceptLoan")
	@ResponseBody
	public Map<String, Object> acceptLoan(String id,String check){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id.trim()));
			if("1".equals(check)){
				//审核通过
				fp.setState("3");
				CashFlow cf = new CashFlow();
				cf.setId(sysService.findId());
				cf.setMoney(fp.getLoanAmount());
				cf.setPayeeMan(fp.getRepaymentMan());
				cf.setPayerMan(fp.getPublicMan());
				cf.setPayDate(new Date());
				cashService.insertSelective(cf);
			}
			if("2".equals(check)){
				//审核不通过
				fp.setState("4");
			}
			financeService.updateByPrimaryKeySelective(fp);
			map.put("result", "ok");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("applyFinance.html")
	public String applyFinanceHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "finance/applyFinance";
	}
	
	@RequestMapping("applyFinance.json")
	public String applyFinancejson(HttpServletRequest request , financProduct fp,String repaymentDateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			fp.setRepaymentDate(sdf.parse(repaymentDateStr));
			fp.setPublicMan(user.getId().toString());
			fp.setState("3");
			financeService.updateByPrimaryKeySelective(fp);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:../loan/allLoan.html";
	}
	
	@RequestMapping("delete.json")
	@ResponseBody
	public String deletejson(HttpServletRequest request , String id){
		Integer num = 0;
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id.trim()) );
			if(StringUtil.isEmpty(fp.getPublicMan())||StringUtil.isEmpty(fp.getRepaymentMan())){
				num = financeService.deleteByPrimaryKey(new BigDecimal(id.trim()) );
				return num.toString();
			}
			return "exist";
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	private void setUserName(List<financProduct> list) throws DaoException{
		for(int i=0;i<list.size();i++){
			SysUser user1 = userService.selectByPrimaryKey(new BigDecimal(list.get(i).getPublicMan()));
			if(user1.getRealName()!=null){
				list.get(i).setPublicManStr(user1.getRealName());
			}else{
				list.get(i).setPublicManStr(user1.getUserName());
			}
			if(StringUtil.isNotEmpty(list.get(i).getRepaymentMan())){
				SysUser user2 = userService.selectByPrimaryKey(new BigDecimal(list.get(i).getRepaymentMan()));
				if(user2.getRealName()!=null){
					list.get(i).setRepaymentManStr(user2.getRealName());
				}else{
					list.get(i).setRepaymentManStr(user2.getUserName());
				}
			}
		}
		
	}
}
