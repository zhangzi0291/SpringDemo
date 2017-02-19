package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> getMyFinanceList(HttpServletRequest request,Page page){
		Map<String, Object> map =new HashMap<String, Object>();
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		try {
			List<financProduct> list = financeService.selectByExample(example);
			Integer count = financeService.countByExample(example);
			map.put("rows",list);
			map.put("total",count);
			return map;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
