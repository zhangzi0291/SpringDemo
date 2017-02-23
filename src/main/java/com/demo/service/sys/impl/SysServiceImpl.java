package com.demo.service.sys.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.sys.SysDao;
import com.demo.service.sys.SysService;

@Service("sysService")
public class SysServiceImpl implements SysService {

	@Resource
	SysDao dao;
	
	@Override
	public BigDecimal findId() {
		Integer b=dao.findId();
		BigDecimal i = new BigDecimal(b);
		return i;
	}

}
