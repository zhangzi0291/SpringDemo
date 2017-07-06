package com.demo.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.demo.base.security.dao.SysAuthoritiesDao;
import com.demo.base.security.dao.SysAuthoritiesResourcesDao;
import com.demo.base.security.dao.SysResourcesDao;
import com.demo.base.security.dto.AuthoritiesResourcesDto;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysAuthoritiesExample;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * 
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {
    private static CustomInvocationSecurityMetadataSourceService  customInvocationSecurityMetadataSourceService ;  
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	@Resource
	private SysResourcesDao sysResourcesDao;
	@Resource
	private SysAuthoritiesDao sysAuthoritiesDao;
	@Resource
	private SysAuthoritiesResourcesDao sysAuthoritiesResourcesDao;
	
	@PostConstruct
	public void init() {
	    SysAuthoritiesExample saExample = new SysAuthoritiesExample();
	    List<SysAuthorities> salist = sysAuthoritiesDao.selectByExample(saExample);
	    resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	    for(SysAuthorities sa : salist){
	        ConfigAttribute ca = new SecurityConfig(sa.getAuthorityName());
	        Map<String, Object> param = new HashMap<>();
	        List<AuthoritiesResourcesDto> ardtoList = sysAuthoritiesResourcesDao.selectResourceAndAuthorities(param);
	        for(AuthoritiesResourcesDto ardto : ardtoList){
	            String url = ardto.getResourceUrl();
	            if (resourceMap.containsKey(url)) {
	                Collection<ConfigAttribute> value = resourceMap.get(url);
	                value.add(ca);
	                resourceMap.put(url, value);
	            }else {
	                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
	                atts.add(ca);
	                resourceMap.put(url, atts);
	            }
	        }
	    }
	}
	public CustomInvocationSecurityMetadataSourceService() {
        loadResourceDefine();
    }
	private void loadResourceDefine() {
	    if(sysResourcesDao==null){
	        return ;
	    }
	    SysAuthoritiesExample saExample = new SysAuthoritiesExample();
        List<SysAuthorities> salist = sysAuthoritiesDao.selectByExample(saExample);
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        for(SysAuthorities sa : salist){
            ConfigAttribute ca = new SecurityConfig(sa.getAuthorityName());
            Map<String, Object> param = new HashMap<>();
            List<AuthoritiesResourcesDto> ardtoList = sysAuthoritiesResourcesDao.selectResourceAndAuthorities(param);
            for(AuthoritiesResourcesDto ardto : ardtoList){
                String url = ardto.getResourceUrl();
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                }else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
	}
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

		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();
			RequestMatcher  requestMatcher = new AntPathRequestMatcher(resURL);
			 if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
				return resourceMap.get(resURL);
			}
		}
		//如果访问的url不在权限控制内可以访问
		return  null;
		//如果访问的url不在权限可访问的范围内报错
//		throw new AccessDeniedException("权限不足");
	}

	@Override
	public boolean supports(Class<?> arg0) {

		return true;
	}

}
