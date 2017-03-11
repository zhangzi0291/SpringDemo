package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.sys.SysUser;
import com.demo.service.sys.SysService;
import com.demo.util.ServletApplicationObject;

@Controller
@RequestMapping("analysis")
public class AnalysisController {
	
	@Resource
	private SysService sysService;
	
	/**
	 * 
	  * 获取历史30天的贷款数据
	  *@param request
	  *@return 
	  *@date 2017年3月5日 上午10:00:01
	  *@author zxn
	 */
	@RequestMapping("getLoanAmount")
	@ResponseBody
	public List<Map<String, String>> getLoanAmount(HttpServletRequest request){
		SysUser user = ServletApplicationObject.getUser(request);
		List<Map<String, String>> map=sysService.getLoanAmount(user.getId().toString());
		return map;
	}
	
	/**
	 * 
	  * 获取历史30天的融资数据
	  *@param request
	  *@return 
	  *@date 2017年3月5日 上午10:00:32
	  *@author zxn
	 */
	@RequestMapping("getRepayment")
	@ResponseBody
	public List<Map<String, String>> getRepayment(HttpServletRequest request){
		SysUser user = ServletApplicationObject.getUser(request);
		List<Map<String, String>> map=sysService.getRepayment(user.getId().toString());
		return map;
	}
	
	/**
	 * 
	  * 检查当前用户信用评级
	  *@date 2017年3月11日 下午6:29:43
	  *@author zxn
	 */
	@RequestMapping("checkCreditRate")
	@ResponseBody
	public String checkCreditRate(HttpServletRequest request){
		SysUser user = ServletApplicationObject.getUser(request);
		String creditRate = user.getCreditRate();
		if (Double.parseDouble(creditRate)>0) {
			return "true";
		}
		return "false";
	}
}
