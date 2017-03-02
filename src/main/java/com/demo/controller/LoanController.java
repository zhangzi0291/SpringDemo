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
@RequestMapping("loan")
public class LoanController {
	
	@Resource
	private FinanceService financeService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CashService cashService;
	
	@Resource
	private SysService sysService;
	
	@RequestMapping("myLoan.html")
	public String myFinanceHtml(){
		return "loan/myLoan";
	}
	
	@RequestMapping("myLoanList")
	@ResponseBody
	public Map<String, Object> getMyLoanList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2 ){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		criteria.andRepaymentManEqualTo(user.getId().toString());
		criteria.andStateNotEqualTo("8");
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
	
	@RequestMapping("newLoan.html")
	public String newLoanHtml(){
		return "loan/newLoan";
	}
	
	@RequestMapping("addLoan.json")
	public String addLoanHtml(HttpServletRequest request, financProduct fp, String repaymentDateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			fp.setRepaymentDate(sdf.parse(repaymentDateStr));
			fp.setRepaymentMan(user.getId().toString());
			fp.setPublicType("2");
			fp.setState("8");
			fp.setCreateDate(DateUtil.getDateByStr(DateUtil.getDate(0)));
			financeService.insertSelective(fp);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:applicationLoan.html";
	}
	
	
	@RequestMapping("editLoan.html")
	public String editLoanHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "loan/editLoan";
	}
	
	@RequestMapping("editLoan.json")
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
		return "redirect:applicationLoan.html";
	}
	
	@RequestMapping("allLoan.html")
	public String allLoanHtml(){
		return "loan/allLoan";
	}
	
	@RequestMapping("allLoanList")
	@ResponseBody
	public Map<String, Object> getAllLoanList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		criteria.andPublicTypeEqualTo("2");
		criteria.andPublicManIsNull();
		criteria.andRepaymentManNotEqualTo(user.getId().toString());
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
	
	@RequestMapping("applyLoan.html")
	public String applyloanHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "loan/applyloan";
	}
	
	@RequestMapping("applicationLoan.html")
	public String applicationLoanHtml(Map<String , Object > map , String id){
		return "loan/applicationLoan";
	}
	
	@RequestMapping("applicationLoanList")
	@ResponseBody
	public Map<String, Object> getApplicationLoanList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2 ){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		criteria.andRepaymentManEqualTo(user.getId().toString());
		criteria.andPublicManIsNull();
		criteria.andPublicTypeEqualTo("2");
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
	public String checkLoan(String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			String pm = fp.getPublicMan();
			String rm = fp.getRepaymentMan();
			if(StringUtil.isNotEmpty(rm)&&StringUtil.isNotEmpty(pm)){
				return "true";
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping("applyLoan.json")
	public String applyloanjson(HttpServletRequest request , financProduct fp,String repaymentDateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			fp.setRepaymentDate(sdf.parse(repaymentDateStr));
			fp.setRepaymentMan(user.getId().toString());
			fp.setState("2");
			financeService.updateByPrimaryKeySelective(fp);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:allLoan.html";
	}
	@RequestMapping("repaymentLoan.html")
	public String repaymentLoanHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			setUserName(fp);
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "loan/repaymentLoan";
	}
	
	@RequestMapping("checkrepayment")
	@ResponseBody
	public String checkrepayment(String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			BigDecimal sum = fp.getInterestRate().divide(new BigDecimal(100)).multiply(fp.getLoanAmount()).add(fp.getLoanAmount()).setScale(0, BigDecimal.ROUND_HALF_UP);
			if("2".equals(fp.getState())){
				//融资人未审核
				return "unaccept";
			}
			if(	fp.getRepaymentBalance().setScale(0, BigDecimal.ROUND_HALF_UP).equals(sum)){
				//贷款还清
				return "end";
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "continue";
	}
	
	@RequestMapping("repaymentLoan.json")
	public String repaymentLoanJson(HttpServletRequest request,Map<String , Object > map , financProduct fp,String repayment,String sum,String repaymentDateStr){
		try {
			BigDecimal balance = fp.getRepaymentBalance()!=null? fp.getRepaymentBalance():new BigDecimal(0);
			fp.setRepaymentBalance(balance.add(new BigDecimal(repayment.trim())));
			
			if("分期还款".equals(fp.getRepaymentMethod())){
				fp.setState("5");
			}
			//是否还款完成
			if( fp.getRepaymentBalance().equals(new BigDecimal(sum.trim()))){
				fp.setState("6");
			}
			financProduct fp2 = financeService.selectByPrimaryKey(fp.getId());
			CashFlow cf = new CashFlow();
			cf.setId(sysService.findId());
			cf.setMoney(new BigDecimal(repayment.trim()));
			cf.setPayeeMan(fp2.getPublicMan());
			cf.setPayerMan(fp2.getRepaymentMan());
			cf.setPayDate(new Date());
			
			cashService.insertSelective(cf);
			financeService.updateByPrimaryKeySelective(fp);
			if(fp2.getRepaymentDate().before(new Date())){
				SysUser user = ServletApplicationObject.getUser(request);
				user.setCreditRate(new BigDecimal(user.getCreditRate()).subtract(new BigDecimal(1)).toString());
				userService.updateByPrimaryKey(user);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:myLoan.html";
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
