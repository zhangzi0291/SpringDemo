package com.demo.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.dao.sys.SysMenuDao;
import com.demo.entity.sys.SysMenu;
import com.demo.entity.sys.SysMenuExample;
import com.demo.service.sys.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<SysMenu, SysMenuExample> implements MenuService {

	@Resource
	private SysMenuDao sysMenuDao;
	
	@Override
	public BaseDao<SysMenu, SysMenuExample> getDao() throws DaoException {
		return sysMenuDao;
	}

}
