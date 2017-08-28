package com.demo.ip.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.exception.DaoException;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.ip.dao.SysIpDao;
import com.demo.ip.entity.SysIp;
import com.demo.ip.entity.SysIpExample;
import com.demo.ip.service.IpService;

@Service("ipService")
public class IpServiceImpl extends BaseServiceImpl<SysIp, SysIpExample> implements IpService{

    @Resource
    private SysIpDao dao;
    
    @Override
    public BaseDao<SysIp, SysIpExample> getDao() throws DaoException {
        return dao;
    }

}
