package com.demo.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.dao.sys.SysUserDao;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.sys.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<SysUser, SysUserExample> implements UserService {

	@Resource
	private SysUserDao sysUserdao;
	
	@Override
	public BaseDao<SysUser, SysUserExample> getDao() throws DaoException {
		return sysUserdao;
	}


}
