package com.demo.base.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<SysResources> getMenu(String userAccount) {
        //如果是admin查全部菜单
        if(userAccount.equals("admin")){
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
        //如果不是admin查有哪些菜单的权限
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userAccount", userAccount);
        List<SysResources> list = dao.selectByUserAccount(param);
        List<SysResources> parent = new ArrayList<>();
        List<SysResources> child = new ArrayList<>();
        list.forEach(sr->{
            if(sr.getParentId().equals("-1")){
                parent.add(sr);
            }else{
                child.add(sr);
            }
        });
        parent.forEach(sr->{
            List<SysResources> childNood = new ArrayList<>();
            child.forEach(csr->{
                if(csr.getParentId().equals(sr.getResourceId())){
                    childNood.add(csr);
                }
            });
            sr.setChild(childNood);
        });
        return parent;
    }
    
    

}
