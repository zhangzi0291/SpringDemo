package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.sys.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Resource 
	UserService userService;
	
	@RequestMapping("userList.html")
	public String userListHtml(){
		return "admin/userlist";
	}
	
	@RequestMapping("userList.json")
	@ResponseBody
	public Map<String, Object> userListJson(){
		Map<String, Object> map =new HashMap<String, Object>();
		SysUserExample example = new SysUserExample();
		try {
			List<SysUser > list = userService.selectByExample(example);
			Integer count = userService.countByExample(example);
			map.put("rows", list);
			map.put("total",count);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return map;
	}
}
