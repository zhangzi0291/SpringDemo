package com.demo.base.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.service.SysUsersService;

/**
 * 登陆之后的操作
  * @ClassName: CustomAuthenticationSuccessHandler
  * @Description: TODO
  * @author Comsys-north
  * @date 2017年7月6日 下午2:50:29
  *
 */
@Component
public class CustomAuthenticationSuccessHandler extends
AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysUsersService sysUsersService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        try {
            SysUsers user = sysUsersService.findByUserAccount(authentication.getName());
            request.getSession().setAttribute("user", user);
        } catch (Exception e) {
            logger.error("Exception ", e);
        } 
        handle(request, response, authentication);  
    }
    
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = "/index.html";
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to "
                    + targetUrl);
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

}
