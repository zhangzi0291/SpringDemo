package com.demo.base.security.service;

import java.util.List;

import com.demo.base.exception.DaoException;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.entity.SysAuthoritiesResourcesExample;
import com.demo.base.service.BaseService;

public interface SysAuthoritiesResourcesService extends BaseService<SysAuthoritiesResources, SysAuthoritiesResourcesExample>{
    Integer saveAuthoritiesResources(String authorityId,List<String> resourceIds) throws DaoException;
    Integer updateAuthoritiesResources(String authorityId,List<String> resourceIds) throws DaoException;
    List<SysAuthoritiesResources> getAuthoritiesResources(String authorityId) throws DaoException;
    Integer delAuthoritiesResources(String authorityId) throws DaoException;
    Integer delAuthoritiesResourcesByResourceId(String resourceId) throws DaoException;
}
