package com.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.entity.financ.financProduct;
import com.demo.entity.financ.financProductExample;
import com.demo.service.finance.FinanceService;

@Controller
@RequestMapping("finance")
public class FinanceController {
	
	@Resource
	private FinanceService financeService;
	
	@RequestMapping("myFinance.html")
	public String myFinanceHtml(){
		return "finance/myFinance";
	}
	
	@RequestMapping("myFinanceList")
	@ResponseBody
	public List<financProduct> getMyFinanceList(HttpServletRequest request,Page page){
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		try {
			List<financProduct> list = financeService.selectByExample(example);
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
