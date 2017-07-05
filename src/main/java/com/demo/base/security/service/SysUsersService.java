package com.demo.base.security.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.demo.base.BaseService;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;


public interface SysUsersService extends BaseService<SysUsers, SysUsersExample>{
    List<GrantedAuthority> loadUserAuthoritiesByName(String username);
    SysUsers findByUserAccount(String userAccount) throws Exception;
}
