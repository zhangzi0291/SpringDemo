package com.demo.base.security.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.base.BaseDao;
import com.demo.base.security.dto.AuthoritiesResourcesDto;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.entity.SysAuthoritiesResourcesExample;

@Repository
public interface SysAuthoritiesResourcesDao extends BaseDao<SysAuthoritiesResources, SysAuthoritiesResourcesExample> {
    List<AuthoritiesResourcesDto> selectResourceAndAuthorities(Map<String, Object> map);
}