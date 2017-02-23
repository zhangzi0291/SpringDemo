package com.demo.service.sys;

import java.math.BigDecimal;

import com.demo.base.BaseService;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;

public interface UserService extends BaseService<SysUser, SysUserExample>{
	
	BigDecimal getUserIdByName(String name);
	
	String getUserNameById(BigDecimal id);
}
