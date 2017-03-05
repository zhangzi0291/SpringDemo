package com.demo.interceptor;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.base.DaoException;
import com.demo.controller.WebController;
import com.demo.entity.sys.BlackList;
import com.demo.entity.sys.BlackListExample;
import com.demo.entity.sys.SysUser;
import com.demo.service.sys.BlackListService;
import com.demo.util.ServletApplicationObject;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Resource  
    WebController  webController ;  
	
	@Resource
	BlackListService blackListService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		String url=request.getRequestURI();
		if(url.indexOf("login")>0||url.indexOf("register")>0||url.indexOf("check")>0||url.indexOf("blackUser")>0){
			return true;
		}
		String username = "";
		String password = "";
		SysUser user = ServletApplicationObject.getUser(request);
		boolean flag=false;
		try {
			BlackListExample example = new BlackListExample();
			List<BlackList> blist = blackListService.selectByExample(example);
			for(BlackList bl : blist){
				if(user.getId().toString().equals(bl.getBlackuserId())){
					flag=true;
				}
			}
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		if(!flag && user != null){
			return true;
		}
		
		Cookie[] cookies = request.getCookies();  
		if (cookies != null) {  
            for (Cookie coo : cookies) {  
            	if("user".equals(coo.getName())){
	                String aa = coo.getValue();  
	                String[] cooks = aa.split("==");  
	                if (cooks.length == 2) {  
	                    username = cooks[0];  
	                    password = cooks[1];  
	                    webController.login(request, response, username, password, "on");
                    	return true;
	                }  
            	}
            }  
        }  
		if(flag){
			try {
				response.sendRedirect(request.getContextPath()+"/blackUser.html");
				return false;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			response.sendRedirect(request.getContextPath()+"/login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
