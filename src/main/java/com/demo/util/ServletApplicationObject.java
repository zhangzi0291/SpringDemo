package com.demo.util;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.sys.SysUser;

public class ServletApplicationObject {
	
	public static SysUser  getUser(HttpServletRequest request){
		return (SysUser) request.getSession().getAttribute("user");
	}
	
	public static void  setUser(HttpServletRequest request,SysUser user){
		request.getSession().setAttribute("user",user);
	}
	
	/**
	 * 
	  * 贷款指数（吃喝话费/可支配收入）
	  *@param money
	  *@return 
	  *@date 2017年3月11日 下午6:45:47
	  *@author zxn
	 */
	public static Double getRate(Double money){
		Double eatMoney = 0.0;
		if(money>10000){
			eatMoney = money*0.2;
		}else if(money>7500){
			eatMoney = money*0.3;
		}else if(money>5000){
			eatMoney = money*0.4;
		}else if(money>3000){
			eatMoney = money*0.5;
		}else{
			eatMoney = money*0.6;
		}
		Double rate = eatMoney/(money -eatMoney);
		return rate;
	}
	
	/**
	 * 
	  * 适合贷款额
	  *@param request
	  *@return 
	  *@date 2017年3月11日 下午6:46:01
	  *@author zxn
	 */
	public static BigDecimal getCanLoan(HttpServletRequest request ){
		SysUser user = getUser(request);
		Double income = user.getRealIncome().doubleValue();
		Double rate = getRate(income);
		Double creditRate = Double.valueOf(user.getCreditRate());
		//如果信用评级小于0，适合贷款数为0
		if(creditRate<=0){
			return new BigDecimal(0);
		}
		//收入 / 贷款指数 + 收入* 信用评级/10
		return new BigDecimal( income/rate+income*creditRate/10);
	}
}
