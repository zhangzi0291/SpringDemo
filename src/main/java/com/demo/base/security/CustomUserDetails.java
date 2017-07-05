package com.demo.base.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *实现了UserDetails，扩展几项信息，比如getSubSystem()方法等 sparta 11/4/13。
 */
public interface CustomUserDetails extends UserDetails {

	//用户id
	public String getUserId();

	//用户账户
	public String getUserAccount();

	//用户名
	public String getUserName();

	//用户密码
	public String getUserPassword();

	//用户描述或简介
	public String getUserDesc();

	//所属的单位
	public String getUserDept();

	//用户职位
	public String getUserDuty();

	//用户分管的子系统
	public String getSubSystem();
	
}
