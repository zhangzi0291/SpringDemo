package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.entity.sys.SysUser;
import com.demo.entity.sys.SysUserExample;
import com.demo.service.sys.UserService;
import com.demo.util.ServletApplicationObject;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Resource
	UserService userService;
	
	/**
	 * 
	  * 跳转我的信息页面
	  *@param request
	  *@param map
	  *@return 
	  *@date 2017年3月5日 上午10:28:59
	  *@author zxn
	 */
	@RequestMapping("myinfo.html")
	public String myinfoHtml(HttpServletRequest request,Map<String, Object> map){
		SysUser user = ServletApplicationObject.getUser(request);
		map.put("user", user);
		return "setting/myInfo";
	}
	
	/**
	 * 
	  * 保存修改的我的信息
	  *@param request
	  *@param user
	  *@return 
	  *@date 2017年3月5日 上午10:29:34
	  *@author zxn
	 */
	@RequestMapping("edituser.json")
	public String edituser(HttpServletRequest request,SysUser user){
		try {
			userService.updateByPrimaryKeySelective(user);
			SysUser newuser = userService.selectByPrimaryKey(user.getId());
			ServletApplicationObject.setUser(request, newuser);

		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:../index.html";
	}
	
	/**
	 * 
	  * 跳转到修改密码
	  *@return 
	  *@date 2017年3月5日 上午10:29:47
	  *@author zxn
	 */
	@RequestMapping("changePwd.html")
	public String changePwdHtml(){
		return "setting/changePwd";
	}
	
	/**
	 * 
	  * 修改密码
	  *@param request
	  *@param userPwd
	  *@return 
	  *@date 2017年3月5日 上午10:30:02
	  *@author zxn
	 */
	@RequestMapping("changePwd.json")
	public String changePwdJson(HttpServletRequest request , String userPwd){
		SysUser user = ServletApplicationObject.getUser(request);
		try {
			user.setUserPwd(userPwd);
			userService.updateByPrimaryKeySelective(user);
			ServletApplicationObject.setUser(request, user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:../index.html";
	}
	
	/**
	 * 
	  * 检查旧密码是否正确
	  *@param request
	  *@param password
	  *@return 
	  *@date 2017年3月5日 上午10:30:17
	  *@author zxn
	 */
	@RequestMapping("checkPwd")
	@ResponseBody
	public String checkPwd(HttpServletRequest request , String password){
		String username = ServletApplicationObject.getUser(request).getUserName();
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
}