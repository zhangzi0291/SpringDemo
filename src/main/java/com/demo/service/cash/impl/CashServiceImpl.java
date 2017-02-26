package com.demo.service.cash.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.PageList;
import com.demo.dao.cash.CashFlowDao;
import com.demo.entity.cash.CashFlow;
import com.demo.entity.cash.CashFlowExample;
import com.demo.service.cash.CashService;

@Service("cashService")
public class CashServiceImpl extends BaseServiceImpl<CashFlow, CashFlowExample> implements CashService {

	@Resource
	CashFlowDao dao;
	
	@Override
	public BaseDao<CashFlow, CashFlowExample> getDao() throws DaoException {
		return dao;
	}

}
