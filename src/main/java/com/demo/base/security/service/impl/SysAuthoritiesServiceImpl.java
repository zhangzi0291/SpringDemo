package com.demo.base.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysAuthoritiesDao;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysAuthoritiesExample;
import com.demo.base.security.service.SysAuthoritiesService;

@Service("SysAuthoritiesService")
public class SysAuthoritiesServiceImpl extends BaseServiceImpl<SysAuthorities, SysAuthoritiesExample> implements SysAuthoritiesService{

    @Resource
    SysAuthoritiesDao dao;
    
    @Override
    public BaseDao<SysAuthorities, SysAuthoritiesExample> getDao() throws DaoException {
        return dao;
    }

}
