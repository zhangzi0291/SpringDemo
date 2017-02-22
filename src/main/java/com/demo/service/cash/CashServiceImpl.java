package com.demo.service.cash;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.PageList;
import com.demo.dao.cash.CashFlowDao;
import com.demo.entity.cash.CashFlow;
import com.demo.entity.cash.CashFlowExample;

public class CashServiceImpl extends BaseServiceImpl<CashFlow, CashFlowExample> implements CashService {

	@Resource
	CashFlowDao dao;
	
	@Override
	public BaseDao<CashFlow, CashFlowExample> getDao() throws DaoException {
		return dao;
	}

}
