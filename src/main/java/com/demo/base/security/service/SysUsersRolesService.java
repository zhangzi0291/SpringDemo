package com.demo.base.security.service;

import java.util.List;

import com.demo.base.BaseService;
import com.demo.base.DaoException;
import com.demo.base.security.entity.SysUsersRoles;
import com.demo.base.security.entity.SysUsersRolesExample;

public interface SysUsersRolesService extends BaseService<SysUsersRoles, SysUsersRolesExample>{
    Integer saveUsersRoles(String userId,List<String > roleIds) throws DaoException;
    Integer updateUsersRoles(String userId,List<String > authorityIds) throws DaoException;
    List<SysUsersRoles> getUsersRoles(String userId) throws DaoException;
    Integer delUsersRoles(String userId) throws DaoException;
}
