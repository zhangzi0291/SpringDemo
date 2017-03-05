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
	
	/**
	 * 
	  * 跳转我的融资页面
	  *@return 
	  *@date 2017年3月5日 上午10:03:36
	  *@author zxn
	 */
	@RequestMapping("myFinance.html")
	public String myFinanceHtml(){
		return "finance/myFinance";
	}
	
	/**
	 * 
	  * 获取我的融资数据
	  *@param request
	  *@param page
	  *@param loanAmount1
	  *@param loanAmount2
	  *@param interestRate1
	  *@param interestRate2
	  *@param repaymentDate1
	  *@param repaymentDate2
	  *@return 
	  *@date 2017年3月5日 上午10:04:08
	  *@author zxn
	 */
	@RequestMapping("myFinanceList")
	@ResponseBody
	public Map<String, Object> getMyFinanceList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		//发布人为当前用户
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
	/**
	 * 
	  * 跳转到发布融资页面
	  *@return 
	  *@date 2017年3月5日 上午10:04:48
	  *@author zxn
	 */
	@RequestMapping("newFinance.html")
	public String newFinanceHtml(){
		return "finance/newFinance";
	}
	
	/**
	 * 
	  * 新建融资产品
	  *@param request
	  *@param fp
	  *@param repaymentDateStr
	  *@return 
	  *@date 2017年3月5日 上午10:05:02
	  *@author zxn
	 */
	@RequestMapping("addFinance.json")
	public String addFinanceJson(HttpServletRequest request, financProduct fp, String repaymentDateStr){
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
	
	/**
	 * 
	  * 跳转到编辑融资页面
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午10:06:34
	  *@author zxn
	 */
	@RequestMapping("editFinance.html")
	public String editFinanceHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			setUserName(fp);
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "finance/editFinance";
	}
	
	/**
	 * 
	  * 保存编辑融资
	  *@param request
	  *@param fp
	  *@param repaymentDateStr
	  *@return 
	  *@date 2017年3月5日 上午10:06:52
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 跳转融资产品页面
	  *@return 
	  *@date 2017年3月5日 上午10:07:07
	  *@author zxn
	 */
	@RequestMapping("allFinance.html")
	public String allFinanceHtml(){
		return "finance/allFinance";
	}
	
	/**
	 * 
	  * 融资产品数据
	  *@param request
	  *@param page
	  *@param loanAmount1
	  *@param loanAmount2
	  *@param interestRate1
	  *@param interestRate2
	  *@param repaymentDate1
	  *@param repaymentDate2
	  *@return 
	  *@date 2017年3月5日 上午10:12:21
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 检查是否需要还款
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午10:12:53
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 审核贷款
	  *@param id
	  *@param check
	  *@return 
	  *@date 2017年3月5日 上午10:13:11
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 跳转贷款申请 放款
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午10:13:37
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 接受贷款申请
	  *@param request
	  *@param fp
	  *@param repaymentDateStr
	  *@return 
	  *@date 2017年3月5日 上午10:14:54
	  *@author zxn
	 */
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
	
	/**
	 * 
	  * 删除还没有被接受的融资产品
	  *@param request
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午10:16:06
	  *@author zxn
	 */
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
