package com.demo.base.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysRolesAuthoritiesDao;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.entity.SysAuthoritiesResourcesExample;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysRolesAuthoritiesExample;
import com.demo.base.security.service.SysRolesAuthoritiesService;

@Service("SysRolesAuthorities")
public class SysRolesAuthoritiesServiceImpl extends BaseServiceImpl<SysRolesAuthorities, SysRolesAuthoritiesExample>
    implements SysRolesAuthoritiesService{
    
    @Resource
    private SysRolesAuthoritiesDao dao;

    @Override
    public BaseDao<SysRolesAuthorities, SysRolesAuthoritiesExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public Integer saveRolesAuthorities(String roleId, List<String> authorityIds) throws DaoException {
        Integer num = 0;
        for(String authorityId: authorityIds){
            SysRolesAuthorities sar = new SysRolesAuthorities();
            sar.setRoleId(roleId);
            sar.setAuthorityId(authorityId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public Integer updateRolesAuthorities(String roleId, List<String> authorityIds) throws DaoException {
        SysRolesAuthoritiesExample example = new SysRolesAuthoritiesExample();
        SysRolesAuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        dao.deleteByExample(example);
        Integer num = 0;
        for(String authorityId: authorityIds){
            SysRolesAuthorities sar = new SysRolesAuthorities();
            sar.setRoleId(roleId);
            sar.setAuthorityId(authorityId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public List<SysRolesAuthorities> getRolesAuthorities(String roleId) throws DaoException {
        SysRolesAuthoritiesExample example = new SysRolesAuthoritiesExample();
        SysRolesAuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<SysRolesAuthorities> list = dao.selectByExample(example);
        return list;
    }

    @Override
    public Integer delRolesAuthorities(String roleId) throws DaoException {
        Integer num = 0;
        SysRolesAuthoritiesExample example = new SysRolesAuthoritiesExample();
        SysRolesAuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        num = dao.deleteByExample(example);
        return num;
    }
    
}
