package com.demo.base.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysRolesDao;
import com.demo.base.security.entity.SysRoles;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysRolesExample;
import com.demo.base.security.entity.SysUsersRoles;
import com.demo.base.security.service.SysRolesService;

@Service("SysRolesService")
public class SysRolesServiceImpl extends BaseServiceImpl<SysRoles, SysRolesExample> implements SysRolesService{

    @Resource
    private SysRolesDao dao;

    @Override
    public BaseDao<SysRoles, SysRolesExample> getDao() throws DaoException {
        return dao;
    }
    
}
