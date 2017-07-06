package com.demo.base.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.security.dao.SysResourcesDao;
import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysResourcesExample;
import com.demo.base.security.service.SysResourcesService;

@Service("sysResourcesService")
public class SysResourcesServiceImpl extends BaseServiceImpl<SysResources, SysResourcesExample> implements SysResourcesService {

    @Resource
    private SysResourcesDao dao;

    @Override
    public BaseDao<SysResources, SysResourcesExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public List<SysResources> getMenu() {
        SysResourcesExample example = new SysResourcesExample();
        SysResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andResourceTypeEqualTo("url");
        criteria.andParentIdEqualTo("-1");
        example.setOrderByClause(" order_num ");
        List<SysResources> list = dao.selectByExample(example);
        list.forEach(sysResources->{
            SysResourcesExample example2 = new SysResourcesExample();
            SysResourcesExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andResourceTypeEqualTo("url");
            criteria2.andParentIdEqualTo(sysResources.getResourceId());
            example2.setOrderByClause(" order_num ");
            List<SysResources> child = dao.selectByExample(example2);
            sysResources.setChild(child);
        });
        return list;
    }
    
    

}
