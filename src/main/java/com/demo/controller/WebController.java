package com.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.entity.sys.SysMenu;
import com.demo.entity.sys.SysMenuExample;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.sys.MenuService;
import com.demo.service.sys.SysService;
import com.demo.service.sys.UserService;
import com.demo.util.ServletApplicationObject;
import com.demo.util.SqLiteUtil;
import com.demo.util.StringUtil;

@Controller
public class WebController {

	@Resource
	private UserService userService;
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private SysService sysService;
	
	@RequestMapping("index.html")
	public String index(HttpServletRequest request , Map<String, Object> map ){
		SysUser user = ServletApplicationObject.getUser(request);
		BigDecimal canLoan= ServletApplicationObject.getCanLoan(request).setScale(2,BigDecimal.ROUND_HALF_UP);
		Map<String, String> money = sysService.findMoneyByUserId(user.getId().toString());
		System.out.println(money.get("repayment"));
		map.put("money", money);
		map.put("canLoan", canLoan);
		return "index";
	}
	
	@RequestMapping("login.html")
	public String loginHtml(){
		return "base/login";
	}
	@RequestMapping("login")
	public String login(HttpServletRequest request,HttpServletResponse response,String username,String password,String remember){
		request.getSession().setAttribute("title", "在线投融资信息平台");
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		criteria.andUserPwdEqualTo(password);
		try {
			List<SysUser> userList = userService.selectByExample(example);
			if(userList.size()>0){
				SysUser user = userList.get(0);
				ServletApplicationObject.setUser(request, user);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if("on".equals(remember)){
			Cookie cookie = new Cookie("user", username+"=="+password); 
			response.addCookie(cookie);  
		}else{
			Cookie cookie = new Cookie("user", null); 
			response.addCookie(cookie);  
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("checkusername")
	@ResponseBody
	public String checkusername(String username){
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		try {
			List<SysUser> userList = userService.selectByExample(example);
			if(userList.size()>0){
				SysUser user = userList.get(0);
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
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		criteria.andUserPwdEqualTo(password);
		try {
			List<SysUser> userList = userService.selectByExample(example);
			if(userList.size()>0){
				SysUser user = userList.get(0);
				return user.getUserName();
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "false";
	}
	
	
	@RequestMapping("register.html")
	public String registerHtml(){
		return "base/register";
	}
	@RequestMapping("register")
	public String register(SysUser user){
		Integer num = 0;
		try {
			num=userService.insertSelective(user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:login.html";
	}
	@RequestMapping("checkregister")
	@ResponseBody
	public String checkregister(String username){
		if("admin".equals(username)){
			return username;
		}
		return "false";
	}
	
	@RequestMapping("getMenu")
	@ResponseBody
	public List<SysMenu> getMenu(HttpServletRequest request){
		try {
			SysMenuExample example = new SysMenuExample();
			SysMenuExample.Criteria criteria = example.createCriteria();
			criteria.andMenuPidEqualTo(new BigDecimal(-1));
			criteria.andMenuOrderNotEqualTo(new BigDecimal(0));
			List<SysMenu> menu1= menuService.selectByExample(example);
			for(int i=0;i<menu1.size();i++){
				SysMenu param = menu1.get(i);
				BigDecimal id = param.getId();
				SysMenuExample example2 = new SysMenuExample();
				SysMenuExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andMenuPidEqualTo(id);
				List<SysMenu> menu2 = menuService.selectByExample(example2);
				menu1.get(i).setChild(menu2);
			}
			return menu1;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("getAdminMenu")
	@ResponseBody
	public List<SysMenu> getAdminMenu(HttpServletRequest request){
		try {
			SysMenuExample example = new SysMenuExample();
			SysMenuExample.Criteria criteria = example.createCriteria();
			criteria.andMenuPidEqualTo(new BigDecimal(-1));
			criteria.andMenuOrderEqualTo(new BigDecimal(0));
			List<SysMenu> menu1= menuService.selectByExample(example);
			for(int i=0;i<menu1.size();i++){
				SysMenu param = menu1.get(i);
				BigDecimal id = param.getId();
				SysMenuExample example2 = new SysMenuExample();
				SysMenuExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andMenuPidEqualTo(id);
				List<SysMenu> menu2 = menuService.selectByExample(example2);
				menu1.get(i).setChild(menu2);
			}
			return menu1;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("setMenu")
	@ResponseBody
	public String setMenu(HttpServletRequest request,Page page){
		String menuName = request.getParameter("menuName");
		if(StringUtil.isNotEmpty(menuName)){
			request.getSession().setAttribute("nowMenu", menuName);
		}
		return menuName;
	}
	@RequestMapping("exit")
	public String exit(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:login.html";
	}
	
	@RequestMapping("blackUser.html")
	public String blacklist(){
		return "base/blackList";
	}
}
