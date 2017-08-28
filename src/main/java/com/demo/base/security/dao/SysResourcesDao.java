package com.demo.base.security.dao;

import java.util.List;
import java.util.Map;

import com.demo.base.dao.BaseDao;
import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysResourcesExample;

public interface SysResourcesDao extends BaseDao<SysResources, SysResourcesExample> {
    List<SysResources> selectByUserAccount(Map<String, Object> param);
}