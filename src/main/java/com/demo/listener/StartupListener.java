package com.demo.listener;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent >{

    @Resource
    private HttpServletRequest request;  
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        request.getSession().setAttribute("basePath", request.getContextPath());
    }

}
