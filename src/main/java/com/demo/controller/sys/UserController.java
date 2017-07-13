package com.demo.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;
import com.demo.base.security.entity.SysUsersRoles;
import com.demo.base.security.service.SysUsersRolesService;
import com.demo.base.security.service.SysUsersService;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("user")
public class UserController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysUsersService sysUsersService;
    @Resource
    private SysUsersRolesService sysUsersRolesService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "sys/user/userList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysUsers user, Page page){
        Map<String, Object> result = new HashMap<>();
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(user.getUserName())){
            criteria.andUserNameLike("%"+user.getUserName()+"%");
        }
        example.setPage(page);
        try {
            List<SysUsers> list = sysUsersService.selectByExample(example);
            Integer count = sysUsersService.countByExample(example);
            result.put("rows", list);
            result.put("total", count);
            return result;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
    @RequestMapping("add.html")
    public String addHtml(){
        return "sys/user/userAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(Map<String, Object> map, SysUsers user,@RequestParam("roleIds") List<String> roleIds){
        try {
            String userId = StringUtil.getUUID();
            user.setUserId(userId);
            if(StringUtil.isNotEmpty(user.getPassword())){
                try {
                    user.setUserPassword(StringUtil.md5Encode(user.getPassword()));
                } catch (Exception e) {
                    logger.error("Exception ", e);
                }
            }
            Integer num = sysUsersService.insertSelective(user);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysUsersRolesService.saveUsersRoles(userId, roleIds);
            if(num==0){
                throw new DaoException();
            }
        } catch (DaoException e) {
            map.put("error", "保存失败  "+e.getMessage());
            logger.error("Exception ", e);
            return "redirect:add.html";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, String userId){
        try {
            SysUsers user = sysUsersService.selectByPrimaryKey(userId);
            map.put("info", user);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "sys/user/userEdit";
    }
    /**
      * 一句话描述这个方法的作用
      *@param map
      *@param user
      *@param roleIds
      *@return 
      *@date 2017年7月13日 上午11:18:31
      *@author zxn
      */
    
    
    @RequestMapping("edit.json")
    @Transactional
    public String editJson(Map<String, Object> map, SysUsers user,@RequestParam("roleIds") List<String> roleIds){
        try {
            if(StringUtil.isNotEmpty(user.getPassword())){
                try {
                    user.setUserPassword(StringUtil.md5Encode(user.getPassword()));
                } catch (Exception e) {
                    logger.error("Exception ", e);
                }
            }else{
                user.setUserPassword(null);
            }
            Integer num = sysUsersService.updateByPrimaryKeySelective(user);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysUsersRolesService.updateUsersRoles(user.getUserId(), roleIds);
            if(num==0){
                throw new DaoException();
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "redirect:add.html";
        }
        return "redirect:list.html";
    }
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<String >ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=sysUsersService.deleteByPrimaryKey(ids.get(i));
                sysUsersRolesService.delUsersRoles(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
    
    @RequestMapping("getUserRoles.json")
    @ResponseBody
    public List<SysUsersRoles> getUsersRoles(String userId ){
        try {
            List<SysUsersRoles> list = sysUsersRolesService.getUsersRoles(userId);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
}