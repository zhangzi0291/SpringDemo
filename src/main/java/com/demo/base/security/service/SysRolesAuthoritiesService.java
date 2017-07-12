package com.demo.base.security.service;

import java.util.List;

import com.demo.base.BaseService;
import com.demo.base.DaoException;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysRolesAuthoritiesExample;

public interface SysRolesAuthoritiesService extends BaseService<SysRolesAuthorities, SysRolesAuthoritiesExample>{
    Integer saveRolesAuthorities(String roleId,List<String > authorityIds) throws DaoException;
    Integer updateRolesAuthorities(String roleId,List<String > authorityIds) throws DaoException;
    List<SysRolesAuthorities> getRolesAuthorities(String roleId) throws DaoException;
    Integer delRolesAuthorities(String roleId) throws DaoException;
}
