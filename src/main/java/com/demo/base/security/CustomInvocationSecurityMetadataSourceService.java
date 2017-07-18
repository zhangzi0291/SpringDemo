package com.demo.base.security;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.base.security.dao.SysAuthoritiesDao;
import com.demo.base.security.dao.SysAuthoritiesResourcesDao;
import com.demo.base.security.dao.SysResourcesDao;
import com.demo.base.security.entity.SysUsers;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * 
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {
    private Logger logger  = LoggerFactory.getLogger(this.getClass());
	@Resource
	private SysResourcesDao sysResourcesDao;
	@Resource
	private SysAuthoritiesDao sysAuthoritiesDao;
	@Resource
	private SysAuthoritiesResourcesDao sysAuthoritiesResourcesDao;
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	// 根据URL，找到相关的权限配置。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
	    FilterInvocation filterInvocation = (FilterInvocation) object;
		// object 是一个URL，被用户请求的url。
	    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	    ServletContext servletContext = webApplicationContext.getServletContext();
	    Map<String, Collection<ConfigAttribute>> resourceMap = (Map<String, Collection<ConfigAttribute>>) servletContext.getAttribute("resourceMap");
		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();
			RequestMatcher  requestMatcher = new AntPathRequestMatcher(resURL);
			if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
				return resourceMap.get(resURL);
			}
			try {
                HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
                SysUsers user = (SysUsers) request.getSession().getAttribute("user");
                if(user.getUserAccount().equals("admin")){
                    return resourceMap.get(resURL);
                }
            } catch (Exception e) {
                logger.error("Exception ", e);
            }
		}
		//如果访问的url不在权限控制内可以访问
//		return  null;
		//如果访问的url不在权限可访问的范围内报错
		throw new AccessDeniedException("权限不足");
	}

	@Override
	public boolean supports(Class<?> arg0) {

		return true;
	}

}
