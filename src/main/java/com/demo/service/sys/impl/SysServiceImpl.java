package com.demo.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.sys.SysDao;
import com.demo.service.sys.SysService;

@Service("sysService")
public class SysServiceImpl implements SysService {

	@Resource
	SysDao dao;
	
	@Override
	public Integer findId() {
		return dao.findId();
	}

}
