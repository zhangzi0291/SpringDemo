package com.demo.controller;

import java.math.BigDecimal;
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
import com.demo.util.DateUtil;
import com.demo.util.StringUtil;

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
	public Map<String, Object> getMyFinanceList(HttpServletRequest request, Page page, String loanAmount1, String loanAmount2, String interestRate1,
	        String interestRate2 , String repaymentDate){
		Map<String, Object> map =new HashMap<String, Object>();
		financProductExample example = new financProductExample();
		financProductExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(loanAmount1)){
		    criteria.andLoanAmountGreaterThan(new BigDecimal(loanAmount1));
		}
		if(StringUtil.isNotEmpty(loanAmount2)){
		    criteria.andLoanAmountLessThan(new BigDecimal(loanAmount2));
		}
		if(StringUtil.isNotEmpty(interestRate1)){
		    criteria.andLoanAmountGreaterThan(new BigDecimal(interestRate1));
		}
		if(StringUtil.isNotEmpty(interestRate2)){
		    criteria.andLoanAmountLessThan(new BigDecimal(interestRate2));
		}
		if(StringUtil.isNotEmpty(repaymentDate)){
		    criteria.andRepaymentDateBetween(DateUtil.getDate(repaymentDate, 0, 0, 0), DateUtil.getDate(repaymentDate, 23, 59, 59));
		}
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
