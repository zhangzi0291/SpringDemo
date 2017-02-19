package com.demo.service.finance.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.dao.financ.financProductDao;
import com.demo.entity.financ.financProduct;
import com.demo.entity.financ.financProductExample;
import com.demo.service.finance.FinanceService;

@Service("financeService")
public class FinanceServiceImpl extends BaseServiceImpl<financProduct, financProductExample> implements FinanceService {

	@Resource
	private financProductDao dao;
	
	@Override
	public BaseDao<financProduct, financProductExample> getDao() throws DaoException {
		return dao;
	}

}
