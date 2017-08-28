package com.demo.base.security.service;

import java.util.List;

import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysResourcesExample;
import com.demo.base.service.BaseService;

public interface SysResourcesService extends BaseService<SysResources, SysResourcesExample>{
    
    List<SysResources> getMenu(String userAccount);
}
