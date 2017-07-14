package com.demo.base.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysAuthoritiesResourcesDao;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.entity.SysAuthoritiesResourcesExample;
import com.demo.base.security.service.SysAuthoritiesResourcesService;
import com.demo.util.StringUtil;

@Service("SysAuthoritiesResourcesService")
public class SysAuthoritiesResourcesServiceImpl extends BaseServiceImpl<SysAuthoritiesResources, SysAuthoritiesResourcesExample>
    implements SysAuthoritiesResourcesService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysAuthoritiesResourcesDao dao;
    
    @Override
    public BaseDao<SysAuthoritiesResources, SysAuthoritiesResourcesExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public Integer saveAuthoritiesResources(String authorityId, List<String> resourceIds) throws DaoException {
        Integer num = 0;
        for(String resourceId: resourceIds){
            SysAuthoritiesResources sar = new SysAuthoritiesResources();
            sar.setAuthorityId(authorityId);
            sar.setResourceId(resourceId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public Integer updateAuthoritiesResources(String authorityId, List<String> resourceIds) throws DaoException {
        SysAuthoritiesResourcesExample example = new SysAuthoritiesResourcesExample();
        SysAuthoritiesResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorityIdEqualTo(authorityId);
        dao.deleteByExample(example);
        Integer num = 0;
        for(String resourceId: resourceIds){
            SysAuthoritiesResources sar = new SysAuthoritiesResources();
            sar.setAuthorityId(authorityId);
            sar.setResourceId(resourceId);
            Integer i = dao.insertSelective(sar);
            num+=i;
        }
        return num;
    }

    @Override
    public List<SysAuthoritiesResources> getAuthoritiesResources(String authorityId) throws DaoException {
        SysAuthoritiesResourcesExample example = new SysAuthoritiesResourcesExample();
        SysAuthoritiesResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorityIdEqualTo(authorityId);
        List<SysAuthoritiesResources> list = dao.selectByExample(example);
        return list;
    }

    @Override
    public Integer delAuthoritiesResources(String authorityId) throws DaoException {
        Integer num = 0;
        SysAuthoritiesResourcesExample example = new SysAuthoritiesResourcesExample();
        SysAuthoritiesResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorityIdEqualTo(authorityId);
        num = dao.deleteByExample(example);
        return num;
    }

    @Override
    public Integer delAuthoritiesResourcesByResourceId(String resourceId) throws DaoException {
        Integer num = 0;
        SysAuthoritiesResourcesExample example = new SysAuthoritiesResourcesExample();
        SysAuthoritiesResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andResourceIdEqualTo(resourceId);
        num = dao.deleteByExample(example);
        return num;
    }

}
