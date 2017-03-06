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
	
	public static BigDecimal getCanLoan(HttpServletRequest request ){
		SysUser user = getUser(request);
		Double income = user.getRealIncome().doubleValue();
		Double rate = getRate(income);
		Double creditRate = Double.valueOf(user.getCreditRate());
		if(creditRate<=0){
			return new BigDecimal(0);
		}
		return new BigDecimal( income/rate+income*creditRate/10);
	}
}
