package com.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.entity.financ.financProduct;
import com.demo.entity.financ.financProductExample;
import com.demo.entity.sys.BlackList;
import com.demo.entity.sys.BlackListExample;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.finance.FinanceService;
import com.demo.service.sys.BlackListService;
import com.demo.service.sys.SysService;
import com.demo.service.sys.UserService;
import com.demo.util.DateUtil;
import com.demo.util.ServletApplicationObject;
import com.demo.util.StringUtil;

import oracle.net.aso.c;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Resource
	private FinanceService financeService;
	
	@Resource 
	private UserService userService;
	
	@Resource
	private BlackListService blackListService; 
	
	@Resource
	private SysService sysService;
	
	/**
	 * 
	  * 跳转用户列表
	  *@return 
	  *@date 2017年3月5日 上午9:46:42
	  *@author zxn
	 */
	@RequestMapping("userList.html")
	public String userListHtml(){
		return "admin/userlist";
	}
	
	/**
	 * 
	  * 用户列表数据
	  *@param userName
	  *@param userProfession
	  *@return 
	  *@date 2017年3月5日 上午9:47:00
	  *@author zxn
	 */
	@RequestMapping("userList.json")
	@ResponseBody
	public Map<String, Object> userListJson(String userName ,String userProfession){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(userName)){
			criteria.andUserNameLike("%"+userName+"%");
		}
		if(StringUtil.isNotEmpty(userProfession)){
			criteria.andUserProfessionLike("%"+userProfession+"%");
		}
		try {
			List<SysUser > list = userService.selectByExample(example);
			Integer count = userService.countByExample(example);
			map.put("rows", list);
			map.put("total",count);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 
	  * 删除用户
	  *@param ids
	  *@return 
	  *@date 2017年3月5日 上午9:47:18
	  *@author zxn
	 */
	@RequestMapping("delUser.json")
	@ResponseBody
	public String delUser(@RequestParam(value="ids[]",required=false)String [] ids ){
		Integer num=0;
		for(int i=0;i<ids.length;i++){
			try {
				num+=userService.deleteByPrimaryKey(new BigDecimal(ids[i]));
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		return num.toString();
	}
	/**
	 * 
	  * 用户详情
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午9:48:26
	  *@author zxn
	 */
	@RequestMapping("userInfo.html")
	public String userInfoHtml(Map<String, Object> map ,String id ){
		try {
			SysUser user = userService.selectByPrimaryKey(new BigDecimal(id));
			String realName = user.getRealName();
			String idNumber = user.getIdNumber();
			user.setRealName(realName.substring(0, realName.length()-1)+"*");
			user.setIdNumber(idNumber.substring(0, idNumber.length()-10)+"**********");
			map.put("user", user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "admin/userInfo";
	}
	
	/**
	 * 
	  * 跳转所有贷款申请页面
	  *@return 
	  *@date 2017年3月5日 上午9:48:53
	  *@author zxn
	 */
	@RequestMapping("allLoan.html")
	public String allLoanHtml(){
		return "admin/allLoan";
	}
	
	/**
	 * 
	  * 所有贷款申请数据
	  *@param request
	  *@param page
	  *@param loanAmount1
	  *@param loanAmount2
	  *@param interestRate1
	  *@param interestRate2
	  *@param repaymentDate1
	  *@param repaymentDate2
	  *@return 
	  *@date 2017年3月5日 上午9:50:30
	  *@author zxn
	 */
	@RequestMapping("allLoanList")
	@ResponseBody
	public Map<String, Object> getAllLoanList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate1 , String repaymentDate2){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
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
	
	/**
	 * 
	  * 跳转所有融资产品
	  *@return 
	  *@date 2017年3月5日 上午9:51:17
	  *@author zxn
	 */
	@RequestMapping("allFinance.html")
	public String allFinanceHtml(){
		return "admin/allFinance";
	}
	
	/**
	 * 
	  * 所有融资产品数据
	  *@param request
	  *@param page
	  *@param loanAmount1
	  *@param loanAmount2
	  *@param interestRate1
	  *@param interestRate2
	  *@param repaymentDate1
	  *@param repaymentDate2
	  *@return 
	  *@date 2017年3月5日 上午9:52:09
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
	  * 查看融资产品详情
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午9:52:19
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
		return "admin/editFinance";
	}
	
	/**
	 * 
	  * 查看贷款申请详情
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午9:52:48
	  *@author zxn
	 */
	@RequestMapping("editLoan.html")
	public String editLoanHtml(Map<String , Object > map , String id){
		try {
			financProduct fp = financeService.selectByPrimaryKey(new BigDecimal(id));
			setUserName(fp);
			map.put("info", fp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "admin/editLoan";
	}
	
	/**
	 * 
	  * 跳转黑名单页面
	  *@return 
	  *@date 2017年3月5日 上午9:53:04
	  *@author zxn
	 */
	@RequestMapping("blackList.html")
	public String blacklistHtml(){
		return "admin/blackList";
	}
	
	/**
	 * 
	  * 黑名单数据
	  *@param request
	  *@param page
	  *@return 
	  *@date 2017年3月5日 上午9:53:18
	  *@author zxn
	 */
	@RequestMapping("blackList.json")
	@ResponseBody
	public Map<String, Object> blackListJson(HttpServletRequest request, Page page , String userId ){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUser user = ServletApplicationObject.getUser(request);
		BlackListExample example = new BlackListExample();
		BlackListExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(userId)){
			criteria.andBlackuserIdEqualTo(userId);
		}
		try {
			List<BlackList> list = blackListService.selectByExample(example);
			Integer count = blackListService.countByExample(example);
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
	  * 黑名单详细信息
	  *@param map
	  *@param id
	  *@return 
	  *@date 2017年3月5日 上午9:57:56
	  *@author zxn
	 */
	@RequestMapping("blackListDetail.html")
	public String blackListDetail(Map<String , Object > map , String id ){
		try {
			BlackList bl = blackListService.selectByPrimaryKey(new BigDecimal(id));
			SysUser user = userService.selectByPrimaryKey(new BigDecimal(bl.getBlackuserId()));
			map.put("info", bl);
			map.put("user",user);
		} catch (DaoException e) {	
			e.printStackTrace();
		}
		return "admin/blackListDetail";
	}
	
	/**
	 * 
	  * 获取除了admin和黑名单的用户
	  *@return 
	  *@date 2017年3月5日 上午9:58:15
	  *@author zxn
	 */
	@RequestMapping("getAllUser.json")
	@ResponseBody
	public List<SysUser> getallUser(){
		List<BigDecimal> idList = new ArrayList<>();
		try {
			BlackListExample example = new BlackListExample();
			BlackListExample.Criteria criteria = example.createCriteria();
			List<BlackList> list = blackListService.selectByExample(example);
			//添加用户id到idList
			for(BlackList bl : list){
				idList.add(new BigDecimal(bl.getBlackuserId()));
			}
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		SysUserExample example2 = new SysUserExample();
		SysUserExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andIdNotEqualTo(new BigDecimal(1));
		if(idList.size()>0){
			criteria2.andIdNotIn(idList);
		}
		try {
			List<SysUser>userlist = userService.selectByExample(example2);
			return userlist;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	  * 添加一个黑名单用户
	  *@param userId
	  *@param bremark
	  *@return 
	  *@date 2017年3月5日 上午9:59:12
	  *@author zxn
	 */
	@RequestMapping("addBlackList.json")
	@ResponseBody
	public String addBlackList(String userId,String bremark){
		Integer num=0;
		BlackList bl = new BlackList();
		bl.setId(sysService.findId());
		bl.setBlackuserId(userId);
		bl.setRemark(bremark);
		try {
			num = blackListService.insert(bl);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return num.toString();
	}
	
	/**
	 * 
	  * 删除黑名单用户
	  *@param ids
	  *@return 
	  *@date 2017年3月5日 上午9:59:23
	  *@author zxn
	 */
	@RequestMapping("delBlackList.json")
	@ResponseBody
	public String delBlackList(@RequestParam(value="ids[]",required=false)String [] ids ){
		Integer num=0;
		for(int i=0;i<ids.length;i++){
			try {
				num+=blackListService.deleteByPrimaryKey(new BigDecimal(ids[i]));
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		return num.toString();
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
