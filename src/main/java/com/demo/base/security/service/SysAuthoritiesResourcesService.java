package com.demo.base.security.service;

import java.util.List;

import com.demo.base.BaseService;
import com.demo.base.DaoException;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.entity.SysAuthoritiesResourcesExample;

public interface SysAuthoritiesResourcesService extends BaseService<SysAuthoritiesResources, SysAuthoritiesResourcesExample>{
    Integer saveAuthoritiesResources(String authorityId,List<String> resourceIds) throws DaoException;
    Integer updateAuthoritiesResources(String authorityId,List<String> resourceIds) throws DaoException;
    List<SysAuthoritiesResources> getAuthoritiesResources(String authorityId) throws DaoException;
    Integer delAuthoritiesResources(String authorityId) throws DaoException;
}
