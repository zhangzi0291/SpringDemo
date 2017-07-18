package com.demo.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysRoles;
import com.demo.base.security.entity.SysRolesAuthorities;
import com.demo.base.security.entity.SysRolesAuthoritiesExample;
import com.demo.base.security.entity.SysRolesExample;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersRoles;
import com.demo.base.security.service.SysRolesAuthoritiesService;
import com.demo.base.security.service.SysRolesService;
import com.demo.base.security.service.SysUsersRolesService;
import com.demo.listener.StartupListener;
import com.demo.util.StringUtil;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@Controller
@RequestMapping("role")
public class RoleController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private SysRolesService sysRolesService;
    @Resource
    private SysRolesAuthoritiesService sysRolesAuthoritiesService;
    @Resource
    private SysUsersRolesService sysUsersRolesService;
    @Resource
    private StartupListener startupListener;
    
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "sys/role/roleList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysRoles role, Page page){
        Map<String, Object> result = new HashMap<>();
        SysRolesExample example = new SysRolesExample();
        SysRolesExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(role.getRoleId())){
            criteria.andRoleIdLike("%"+role.getRoleId()+"%");
        }
        if(role.getEnabled()!=null){
            criteria.andEnabledEqualTo(role.getEnabled());
        }
        example.setPage(page);
        try {
            List<SysRoles> list = sysRolesService.selectByExample(example);
            Integer count = sysRolesService.countByExample(example);
            
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
        return "sys/role/roleAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(Map<String, Object> map, SysRoles auth,@RequestParam("authorityIds") List<String> authorityIds){
        try {
            String roleId = StringUtil.getUUID();
            auth.setRoleId(roleId);
            Integer num = sysRolesService.insertSelective(auth);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysRolesAuthoritiesService.saveRolesAuthorities(roleId, authorityIds);
            if(num==0){
                throw new DaoException();
            }
        } catch (DaoException e) {
            map.put("error", "保存失败  "+e.getMessage());
            logger.error("Exception ", e);
            return "redirect:add.html";
        }
        startupListener.loadResourceDefine();
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, String roleId){
        try {
            SysRoles auth = sysRolesService.selectByPrimaryKey(roleId);
            map.put("info", auth);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "sys/role/roleEdit";
    }
    @RequestMapping("edit.json")
    @Transactional
    public String editJson(Map<String, Object> map, SysRoles auth,@RequestParam("authorityIds") List<String> authorityIds){
        try {
            Integer num = sysRolesService.updateByPrimaryKeySelective(auth);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysRolesAuthoritiesService.updateRolesAuthorities(auth.getRoleId(), authorityIds);
            if(num==0){
                throw new DaoException();
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "redirect:add.html";
        }
        startupListener.loadResourceDefine();
        return "redirect:list.html";
    }
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(HttpServletRequest request, Map<String, Object> map, @RequestParam("ids[]") List<String >ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                sysUsersRolesService.delUsersRolesByRole(ids.get(i));
                num+=sysRolesService.deleteByPrimaryKey(ids.get(i));
                sysRolesAuthoritiesService.delRolesAuthorities(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
    
    @RequestMapping("getRoleAuth.json")
    @ResponseBody
    public List<SysRolesAuthorities> getRoleAuth(String roleId ){
        try {
            List<SysRolesAuthorities> list = sysRolesAuthoritiesService.getRolesAuthorities(roleId);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    @RequestMapping("getRole.json")
    @ResponseBody
    public List<SysRoles> getRole(){
        try {
            SysRolesExample example = new SysRolesExample();
            SysRolesExample.Criteria criteria= example.createCriteria();
            List<SysRoles> list = sysRolesService.selectByExample(example);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
}
