package com.demo.service.sys.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.dao.sys.SysUserDao;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.sys.UserService;
import com.demo.util.StringUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<SysUser, SysUserExample> implements UserService {

	@Resource
	private SysUserDao sysUserdao;
	
	@Override
	public BaseDao<SysUser, SysUserExample> getDao() throws DaoException {
		return sysUserdao;
	}

	@Override
	public BigDecimal getUserIdByName(String name) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		SysUserExample.Criteria criteria2 = example.createCriteria();
		criteria.andRealNameEqualTo(name);
		criteria2.andUserNameEqualTo(name);
		example.or(criteria2);
		List<SysUser > list = sysUserdao.selectByExample(example);
		if(list.size() == 1){
			return list.get(0).getId();
		}
		return null;
	}
	
	@Override
	public String getUserNameById(BigDecimal id) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<SysUser > list = sysUserdao.selectByExample(example);
		if(list.size() == 1){
			if(StringUtil.isNotEmpty(list.get(0).getRealName())){
				return list.get(0).getRealName();				
			}else {
				return list.get(0).getUserName();
			}
		}
		return null;
	}


}
