package com.demo.interceptor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.controller.WebController;
import com.demo.entity.sys.SysUser;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Resource  
    WebController  webController ;  
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		String username = "";
		String password = "";
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if(user != null){
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
		String url=request.getRequestURI();
		if(url.indexOf("login")>0||url.indexOf("register")>0||url.indexOf("check")>0){
			return true;
		}else{
			try {
				response.sendRedirect(request.getContextPath()+"/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}
