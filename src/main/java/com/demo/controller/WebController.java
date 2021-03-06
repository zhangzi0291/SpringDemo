package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.aspect.AddLog;
import com.demo.base.exception.DaoException;
import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;
import com.demo.base.security.service.SysResourcesService;
import com.demo.base.security.service.SysUsersService;
import com.demo.util.StringUtil;

@Controller
public class WebController {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysUsersService sysUsersService;
    @Resource
    private SysResourcesService sysResourcesService;

    
	@RequestMapping("index.html")
	@AddLog("跳转首页")
	public String index(HttpServletRequest request){
		return "index";
	}
	@RequestMapping("403.html")
	public String h403(){
	    return "base/403";
	}
	@RequestMapping("404.html")
	public String h404(){
	    return "base/404";
	}
	@RequestMapping("500.html")
	public String h500(){
	    return "base/500";
	}
	@RequestMapping("timeout.html")
	public String timeout(){
	    return "base/timeout";
	}
	@RequestMapping("logout.html")
	@AddLog("注销")
	public String logout(){
	    return "base/logout";
	}
	@RequestMapping("getMenu")
	@ResponseBody
	public List<SysResources> getMenu(HttpServletRequest request){
	    SysUsers user  = (SysUsers) request.getSession().getAttribute("user");
	    if(user == null){
	        return null;
	    }
		List<SysResources> menu = sysResourcesService.getMenu(user.getUserAccount());
		return menu;
	}
	@RequestMapping("setMenu")
	@ResponseBody
	public void setMenu(HttpServletRequest request, String menuName, String childName){
        if(StringUtil.isNotEmpty(menuName)){
            request.getSession().setAttribute("nowMenu", menuName);
        }
        if(StringUtil.isNotEmpty(childName)){
            request.getSession().setAttribute("nowChild", childName);
        }
	}
	@RequestMapping("login.html")
	@AddLog("跳转登陆页面")
	public String loginHtml(HttpServletRequest request){
	    return "base/login";
	}
	@RequestMapping("register.html")
	@AddLog("跳转注册页面")
	public String registerHtml(){
	    return "base/register";
	}
	
	@RequestMapping("test")
	@ResponseBody
	public String tset(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    throw new IOException();
//	    return "test-data";
	}
	
	@RequestMapping("checkusername")
    @ResponseBody
    public String checkusername(String username){
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(username);
        try {
            List<SysUsers> userList = sysUsersService.selectByExample(example);
            if(userList.size()>0){
                SysUsers user = userList.get(0);
                return user.getUserAccount();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "false";
    }
    @RequestMapping("checklogin")
    @ResponseBody
    public String checklogin(String username,String password){
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(username);
        try {
            String md5password = StringUtil.md5Encode(password);
            criteria.andUserPasswordEqualTo(md5password);
        } catch (Exception e1) {
            logger.error("Exception ", e1);
        }
        try {
            List<SysUsers> userList = sysUsersService.selectByExample(example);
            if(userList.size()>0){
                SysUsers user = userList.get(0);
                return user.getUserAccount();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "false";
    }
    
    @RequestMapping("checkregister")
    @ResponseBody
    public String checkregister(String username){
        if("admin".equals(username)){
            return username;
        }
        return "false";
    }
//    @RequestMapping("logout")
//    public String logout(String username){
//        if("admin".equals(username)){
//            return username;
//        }
//        return "false";
//    }
}
