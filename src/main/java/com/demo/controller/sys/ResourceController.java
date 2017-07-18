package com.demo.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.security.entity.SysResources;
import com.demo.base.security.entity.SysResourcesExample;
import com.demo.base.security.service.SysResourcesService;
import com.demo.base.security.service.SysRolesAuthoritiesService;
import com.demo.listener.StartupListener;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("resource")
public class ResourceController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private SysResourcesService sysResourcesService;
    @Resource
    private SysRolesAuthoritiesService sysRolesAuthoritiesService;
    @Resource
    private StartupListener startupListener;
    
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "sys/resource/resourceList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysResources sysResources, Page page){
        Map<String, Object> result = new HashMap<>();
        SysResourcesExample example = new SysResourcesExample();
        SysResourcesExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(sysResources.getResourceName())){
            criteria.andResourceNameLike("%"+sysResources.getResourceName()+"%");
        }
        if(StringUtil.isNotEmpty(sysResources.getResourceType())){
            criteria.andResourceTypeEqualTo(sysResources.getResourceType());
        }
        example.setPage(page);
        try {
            List<SysResources> list = sysResourcesService.selectByExample(example);
            Integer count = sysResourcesService.countByExample(example);
            
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
        return "sys/resource/resourceAdd";
    }
    @RequestMapping("add.json")
    public String addJson(Map<String, Object> map, SysResources resources){
        try {
            resources.setResourceId(StringUtil.getUUID());
            Integer num = sysResourcesService.insertSelective(resources);
            if(num==0){
                map.put("error", "保存失败");
                return "redirect:add.html";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "redirect:add.html";
        }
        startupListener.loadResourceDefine();
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, String resourceId){
        try {
            SysResources resource = sysResourcesService.selectByPrimaryKey(resourceId);
            map.put("info", resource);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "sys/resource/resourceEdit";
    }
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, SysResources resources){
        try {
            Integer num = sysResourcesService.updateByPrimaryKeySelective(resources);
            if(num==0){
                map.put("error", "保存失败");
                return "redirect:edit.html";
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
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<String >ids ){
        Integer num = 0;
        for(int i=0;i<ids.size();i++){
            try {
                sysRolesAuthoritiesService.delRolesAuthoritiesByAuthorityId(ids.get(i));
                num+=sysResourcesService.deleteByPrimaryKey(ids.get(i));
            } catch (DaoException e) {
                logger.error("Exception ", e);
            }
        }
        return num.toString();
    }
    
    @RequestMapping("getParentId.json")
    @ResponseBody
    public List<SysResources> getParentId(String parentId,String type){
        SysResourcesExample example = new SysResourcesExample();
        SysResourcesExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(type)){
            criteria.andResourceTypeEqualTo(type);
        }
        if(StringUtil.isNotEmpty(parentId)){
            criteria.andParentIdEqualTo(parentId);
        }
        example.setOrderByClause(" order_num ");
        try {
            List<SysResources> list = sysResourcesService.selectByExample(example);
            return list;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
    @RequestMapping("getResource.json")
    @ResponseBody
    public List<SysResources> getResource(){
        List<SysResources> parentList = new ArrayList<>();
        {
            SysResourcesExample example = new SysResourcesExample();
            SysResourcesExample.Criteria criteria = example.createCriteria();
            SysResourcesExample.Criteria criteria2 = example.createCriteria();
            criteria.andParentIdIsNull();
            criteria2.andParentIdEqualTo("-1");
            example.or(criteria);
            example.or(criteria2);
            example.setOrderByClause(" order_num ");
            try {
                parentList = sysResourcesService.selectByExample(example);
                for(SysResources sr : parentList){
                    setChild(sr);
                }
            } catch (DaoException e) {
                logger.error("Exception ", e);
            }
        }
        return parentList;
    }
    
    private SysResources setChild(SysResources parent){
        SysResourcesExample example = new SysResourcesExample();
        SysResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdIsNotNull();
        criteria.andParentIdEqualTo(parent.getResourceId());
        example.setOrderByClause(" order_num ");
        try {
            List<SysResources> childList = sysResourcesService.selectByExample(example);
            for(SysResources resource: childList){
                setChild(resource);
                if(parent.getChild()==null){
                    List<SysResources> clist = new ArrayList<>();
                    clist.add(resource);
                    parent.setChild(clist);
                    continue;
                }
                parent.getChild().add(resource);
            }
            
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return parent;
    }
}
