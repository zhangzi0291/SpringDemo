package com.demo.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.dao.BoAttachUrlDao;
import com.demo.entity.BoAttachUrl;
import com.demo.entity.BoAttachUrlExample;
import com.demo.service.BoAttachUrlService;

@Service("BoAttachUrlService")
public class BoAttachUrlServiceImpl extends BaseServiceImpl<BoAttachUrl, BoAttachUrlExample> implements BoAttachUrlService{

    @Resource
    private BoAttachUrlDao dao;

    @Override
    public BaseDao<BoAttachUrl, BoAttachUrlExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
