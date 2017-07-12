package com.demo.base.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysUsersRolesDao;
import com.demo.base.security.entity.SysUsersRoles;
import com.demo.base.security.entity.SysUsersRolesExample;
import com.demo.base.security.service.SysUsersRolesService;

@Service("SysUsersRolesService")
public class SysUsersRolesServiceImpl extends BaseServiceImpl<SysUsersRoles, SysUsersRolesExample>implements SysUsersRolesService{
    
    @Resource
    private SysUsersRolesDao dao;

    @Override
    public BaseDao<SysUsersRoles, SysUsersRolesExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public Integer saveUsersRoles(String userId, List<String> roleIds) throws DaoException {
        Integer num = 0;
        for(String roleId: roleIds){
            SysUsersRoles sar = new SysUsersRoles();
            sar.setUserId(userId);
            sar.setRoleId(roleId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public Integer updateUsersRoles(String userId, List<String> roleIds) throws DaoException {
        SysUsersRolesExample example = new SysUsersRolesExample();
        SysUsersRolesExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        dao.deleteByExample(example);
        Integer num = 0;
        for(String roleId: roleIds){
            SysUsersRoles sar = new SysUsersRoles();
            sar.setUserId(userId);
            sar.setRoleId(roleId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public List<SysUsersRoles> getUsersRoles(String userId) throws DaoException {
        SysUsersRolesExample example = new SysUsersRolesExample();
        SysUsersRolesExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SysUsersRoles> list = dao.selectByExample(example);
        return list;
    }

    @Override
    public Integer delUsersRoles(String userId) throws DaoException {
        Integer num = 0;
        SysUsersRolesExample example = new SysUsersRolesExample();
        SysUsersRolesExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        num = dao.deleteByExample(example);
        return num;
    }
}
