package com.demo.util;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.sys.SysUser;

public class ServletApplicationObject {
	
	public static SysUser  getUser(HttpServletRequest request){
		return (SysUser) request.getSession().getAttribute("user");
	}
	
	public static void  setUser(HttpServletRequest request,SysUser user){
		request.getSession().setAttribute("user",user);
	}
	
}
