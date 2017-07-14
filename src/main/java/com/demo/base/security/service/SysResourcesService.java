package com.demo.base.security.service;

import java.util.List;

import com.demo.base.BaseService;
import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysResourcesExample;

public interface SysResourcesService extends BaseService<SysResources, SysResourcesExample>{
    
    List<SysResources> getMenu(String userAccount);
}
