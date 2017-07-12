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
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysAuthoritiesExample;
import com.demo.base.security.entity.SysAuthoritiesResources;
import com.demo.base.security.service.SysAuthoritiesResourcesService;
import com.demo.base.security.service.SysAuthoritiesService;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("authoritie")
public class AuthoritieController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private SysAuthoritiesService sysAuthoritiesService;
    @Resource
    private SysAuthoritiesResourcesService sysAuthoritiesResourcesService;
    
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "authoritie/authoritieList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysAuthorities auth, Page page){
        Map<String, Object> result = new HashMap<>();
        SysAuthoritiesExample example = new SysAuthoritiesExample();
        SysAuthoritiesExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(auth.getAuthorityName())){
            criteria.andAuthorityNameLike("%"+auth.getAuthorityName()+"%");
        }
        if(auth.getEnabled()!=null){
            criteria.andEnabledEqualTo(auth.getEnabled());
        }
        example.setPage(page);
        try {
            List<SysAuthorities> list = sysAuthoritiesService.selectByExample(example);
            Integer count = sysAuthoritiesService.countByExample(example);
            
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
        return "authoritie/authoritieAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(Map<String, Object> map, SysAuthorities auth,@RequestParam("resourceIds") List<String> resourceIds){
        try {
            String authorityId = StringUtil.getUUID();
            auth.setAuthorityId(authorityId);
            Integer num = sysAuthoritiesService.insertSelective(auth);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysAuthoritiesResourcesService.saveAuthoritiesResources(authorityId, resourceIds);
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
    public String editHtml(Map<String, Object> map, String authorityId){
        try {
            SysAuthorities auth = sysAuthoritiesService.selectByPrimaryKey(authorityId);
            map.put("info", auth);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "authoritie/authoritieEdit";
    }
    @RequestMapping("edit.json")
    @Transactional
    public String editJson(Map<String, Object> map, SysAuthorities auth,@RequestParam("resourceIds") List<String> resourceIds){
        try {
            Integer num = sysAuthoritiesService.updateByPrimaryKeySelective(auth);
            if(num==0){
                throw new DaoException();
            }
            num = 0;
            num = sysAuthoritiesResourcesService.updateAuthoritiesResources(auth.getAuthorityId(), resourceIds);
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
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<String >ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                   num+=sysAuthoritiesService.deleteByPrimaryKey(ids.get(i));
                   sysAuthoritiesResourcesService.delAuthoritiesResources(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
    @RequestMapping("getAuthRes.json")
    @ResponseBody
    public List<SysAuthoritiesResources> getAuthRes(String authorityId ){
        try {
            List<SysAuthoritiesResources> list = sysAuthoritiesResourcesService.getAuthoritiesResources(authorityId);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    @RequestMapping("getAuth.json")
    @ResponseBody
    public List<SysAuthorities> getAuth(){
        try {
            SysAuthoritiesExample example = new SysAuthoritiesExample();
            SysAuthoritiesExample.Criteria criteria= example.createCriteria();
            criteria.andEnabledEqualTo(1);
            List<SysAuthorities> list = sysAuthoritiesService.selectByExample(example);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
}
