package com.demo.base.security.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.base.BaseDao;
import com.demo.base.security.dto.AuthoritiesResourcesDto;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysAuthoritiesExample;

@Repository
public interface SysAuthoritiesResourcesDao extends BaseDao<SysAuthorities, SysAuthoritiesExample> {
    List<AuthoritiesResourcesDto> selectResourceAndAuthorities(Map<String, Object> map);
}