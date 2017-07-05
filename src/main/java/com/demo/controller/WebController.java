package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;
import com.demo.base.security.service.SysUsersService;
import com.demo.util.SqLiteUtil;
import com.demo.util.StringUtil;

@Controller
public class WebController {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private SessionAuthenticationStrategy sas;
    @Resource
    private SysUsersService sysUsersService;
    
	@RequestMapping("index.html")
	public String index(){
		return "index";
	}
	@RequestMapping("getMenu")
	@ResponseBody
	public List<Map<String, String>> getMenu(HttpServletRequest request,Page page){
		StringBuffer sql=new StringBuffer("select * from sys_menu where menu_pid='-1' ");
		List menu1=SqLiteUtil.getRowValue(sql.toString());
		for(int i=0;i<menu1.size();i++){
			Map param=(Map) menu1.get(i);
			String id=param.get("id").toString();
			StringBuffer sql2=new StringBuffer("select * from sys_menu where menu_pid=");
			sql2.append("'").append(id).append("'");
			List<Map<String, String>>menu2=SqLiteUtil.getRowValue(sql2.toString());
			param.put("child", menu2);
		}
		return menu1;
	}
	@RequestMapping("setMenu")
	@ResponseBody
	public String setMenu(HttpServletRequest request,Page page){
		return null;
	}
	@RequestMapping("login.html")
	public String loginHtml(){
	    return "base/login";
	}
	@RequestMapping("register.html")
	public String registerHtml(){
	    return "base/register";
	}
	@RequestMapping("test")
	@ResponseBody
	public void tset(HttpServletRequest request,HttpServletResponse response){
 	    UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken("username", "password");
        Authentication authentication=authenticationManager.authenticate(token);
        sas.onAuthentication(authentication, request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	@RequestMapping("checkusername")
    @ResponseBody
    public String checkusername(String username){
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        try {
            List<SysUsers> userList = sysUsersService.selectByExample(example);
            if(userList.size()>0){
                SysUsers user = userList.get(0);
                return user.getUserName();
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
                return user.getUserName();
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
