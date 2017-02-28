package com.demo.service.sys.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, String> findMoneyByUserId(String userId) {
		return dao.findMoneyByUserId(userId);
	}

	@Override
	public List<Map<String, String>> getLoanAmount(String userId) {
		return dao.getLoanAmount(userId);
	}
	
	@Override
	public List<Map<String, String>> getRepayment(String userId) {
		return dao.getRepayment(userId);
	}

}
