package com.demo.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.dao.sys.BlackListDao;
import com.demo.entity.sys.BlackList;
import com.demo.entity.sys.BlackListExample;
import com.demo.service.sys.BlackListService;

@Service("blackListService")
public class BlackListServiceImpl extends BaseServiceImpl<BlackList,BlackListExample> implements BlackListService{

	@Resource
	private BlackListDao dao;
	
	@Override
	public BaseDao<BlackList, BlackListExample> getDao() throws DaoException {
		return dao;
	}

}
