package com.demo.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.base.Page;
import com.demo.base.exception.DaoException;
import com.demo.entity.BoAttachUrl;
import com.demo.entity.BoAttachUrlExample;
import com.demo.service.BoAttachUrlService;

@Controller
@RequestMapping("boAttachUrl")
public class BoAttachUrlController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private BoAttachUrlService boAttachUrlService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "boAttachUrl/boAttachUrlList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(BoAttachUrl boAttachUrl, Page page){
        Map<String, Object> result = new HashMap<>();
        BoAttachUrlExample example = new BoAttachUrlExample();
        BoAttachUrlExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        try {
            List< BoAttachUrl> list = boAttachUrlService.selectByExample(example);
            Integer count = boAttachUrlService.countByExample(example);
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
        return "boAttachUrl/boAttachUrlAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(HttpServletRequest request,Map<String, Object> map, BoAttachUrl boAttachUrl ){
        try {
            Integer num = boAttachUrlService.insertSelective(boAttachUrl);
            if(num==0){
                map.put("error", "保存失败");
                return "boAttachUrl/boAttachUrlAdd";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "boAttachUrl/boAttachUrlAdd";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, Integer id){
        try {
            BoAttachUrl boAttachUrl = boAttachUrlService.selectByPrimaryKey(id);
            map.put("info", boAttachUrl);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "boAttachUrl/boAttachUrlEdit";
    }
   
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, BoAttachUrl boAttachUrl){
        try {
            Integer num = boAttachUrlService.updateByPrimaryKeySelective(boAttachUrl);
            if(num==0){
                map.put("error", "保存失败");
                return "boAttachUrl/boAttachUrlEdit";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "boAttachUrl/boAttachUrlEdit";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<Integer> ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=boAttachUrlService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
}