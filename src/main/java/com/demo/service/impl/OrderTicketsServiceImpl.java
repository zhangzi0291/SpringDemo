package com.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.exception.DaoException;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.dao.ticket.OrderTicketsDao;
import com.demo.entity.ticket.OrderTickets;
import com.demo.entity.ticket.OrderTicketsExample;
import com.demo.service.OrderTicketsService;

@Service("OrderTicketsService")
public class OrderTicketsServiceImpl extends BaseServiceImpl<OrderTickets, OrderTicketsExample> implements OrderTicketsService{

    @Resource
    private OrderTicketsDao dao;

    @Override
    public BaseDao<OrderTickets, OrderTicketsExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
