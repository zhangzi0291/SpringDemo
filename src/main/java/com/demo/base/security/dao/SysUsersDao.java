package com.demo.base.security.dao;

import java.util.List;
import java.util.Map;

import com.demo.base.BaseDao;
import com.demo.base.security.dto.UsersRolesDto;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;

public interface SysUsersDao extends BaseDao<SysUsers, SysUsersExample> {
    
    List<SysAuthorities> loadUserRoles(Map<String, Object> param);
    
}