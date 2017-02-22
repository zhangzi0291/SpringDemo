package com.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.base.DaoException;
import com.demo.entity.financ.financProduct;
import com.demo.entity.sys.SysUser;
import com.demo.service.finance.FinanceService;
import com.demo.service.sys.UserService;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("evaluation")
public class EvaluationController {
	
	@Resource
	private FinanceService financeService;
	
	@Resource
	private UserService userService;
	
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
	
	
	
	/**
	 * 
	  * 获取发布人和贷款人的名字
	  *@param fp
	  *@throws DaoException 
	  *@date 2017年2月22日 上午5:36:57
	  *@author zxn
	 */
	private void setUserName(financProduct fp) throws DaoException{
		SysUser user1 = userService.selectByPrimaryKey(new BigDecimal(fp.getPublicMan()));
		if(user1.getRealName()!=null){
			fp.setPublicManStr(user1.getRealName());
		}else{
			fp.setPublicManStr(user1.getUserName());
		}
		if(StringUtil.isNotEmpty(fp.getRepaymentMan())){
			SysUser user2 = userService.selectByPrimaryKey(new BigDecimal(fp.getRepaymentMan()));
			if(user2.getRealName()!=null){
				fp.setRepaymentManStr(user2.getRealName());
			}else{
				fp.setRepaymentManStr(user2.getUserName());
			}
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
