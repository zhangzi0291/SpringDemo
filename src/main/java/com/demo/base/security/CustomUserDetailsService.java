package com.demo.base.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.base.security.dao.SysAuthoritiesResourcesDao;
import com.demo.base.security.dao.SysUsersDao;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.service.SysUsersService;



/**
 *该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails。
 *该UserDetails包括用户名、密码、是否可用、是否过期等信息。
 *sparta 11/3/29
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Resource
	private SysUsersService sysUsersService;
	@Resource
	private SysAuthoritiesResourcesDao sysAuthoritiesResourcesDao;
//	@Resource
//	private UserCache userCache;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//		//得到用户的权限
		auths = sysUsersService.loadUserAuthoritiesByName( username );
//		//根据用户名取得一个SysUsers对象，以获取该用户的其他信息。
        try {
            SysUsers user = sysUsersService.findByUserAccount( username );
            user.setAuthorities(auths);
            return user;
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
	    return null;
	}
	
	//设置用户缓存功能。
//    public void setUserCache(UserCache userCache) {
//        this.userCache = userCache;
//    }
//    
//    public UserCache getUserCache(){
//    	return this.userCache;
//    }
	
}
