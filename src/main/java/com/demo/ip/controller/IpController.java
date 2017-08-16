package com.demo.ip.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.ip.entity.SysIp;
import com.demo.ip.entity.SysIpExample;
import com.demo.ip.service.IpService;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("ip")
public class IpController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private IpService ipService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "ip/ipList";
    }
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysIp ip,Page page,String date){
        Map<String, Object> result =new HashMap<String, Object>();
        SysIpExample example = new SysIpExample();
        SysIpExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(date)){
            ZoneId zone = ZoneId.systemDefault();
            Instant instant1 = LocalDate.parse(date).atTime(0, 0, 0).atZone(zone).toInstant();
            Date date1 = Date.from(instant1);
            Instant instant2 = LocalDate.parse(date).atTime(23, 59, 59).atZone(zone).toInstant();
            Date date2 = Date.from(instant2);
            criteria.andUpdateTimeBetween(date1, date2);
        }
        example.setPage(page);
        example.setOrderByClause(" update_time desc ");
        try {
            List<SysIp> list = ipService.selectByExample(example);
            int count = ipService.countByExample(example);
            result.put("rows", list);
            result.put("total", count);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return result;
    }
}
