package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.util.StringUtil;

public class MenuInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String menuName = request.getParameter("menuName");
		if(StringUtil.isNotEmpty(menuName)){
			request.getSession().setAttribute("nowMenu", menuName);
		}
		return super.preHandle(request, response, handler);
	}
}
