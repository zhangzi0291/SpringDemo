package com.demo.base.security.service;

import java.util.List;

import com.demo.base.exception.DaoException;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysRolesAuthoritiesExample;
import com.demo.base.service.BaseService;

public interface SysRolesAuthoritiesService extends BaseService<SysRolesAuthorities, SysRolesAuthoritiesExample>{
    Integer saveRolesAuthorities(String roleId,List<String > authorityIds) throws DaoException;
    Integer updateRolesAuthorities(String roleId,List<String > authorityIds) throws DaoException;
    List<SysRolesAuthorities> getRolesAuthorities(String roleId) throws DaoException;
    Integer delRolesAuthorities(String roleId) throws DaoException;
    Integer delRolesAuthoritiesByAuthorityId(String authorityId) throws DaoException;
}
