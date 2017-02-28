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
	
	@RequestMapping("getLoanAmount")
	@ResponseBody
	public List<Map<String, String>> getLoanAmount(HttpServletRequest request){
		SysUser user = ServletApplicationObject.getUser(request);
		List<Map<String, String>> map=sysService.getLoanAmount(user.getId().toString());
		return map;
	}
	
	@RequestMapping("getRepayment")
	@ResponseBody
	public List<Map<String, String>> getRepayment(HttpServletRequest request){
		SysUser user = ServletApplicationObject.getUser(request);
		List<Map<String, String>> map=sysService.getRepayment(user.getId().toString());
		return map;
	}
}
