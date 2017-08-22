package com.demo.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.aspect.AddLog;
import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.quartz.entity.SysJob;
import com.demo.base.security.entity.SysUsers;
import com.demo.entity.ticket.OrderTickets;
import com.demo.entity.ticket.OrderTicketsExample;
import com.demo.entity.ticket.TicketsInfo;
import com.demo.service.OrderTicketsService;
import com.demo.util.DateUtil;
import com.demo.util.HttpUtil;
import com.demo.util.SqLiteUtil;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("train")
public class TrainTicketsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private OrderTicketsService orderTicketsService;
    
    public static void main(String[] args) {
        String s ="dK4Lx8o%2FCMZAHGq2%2FH5Qewi1co8ISHgjkFx%2BBigkFiXmwNgSMeX0J7gCzAcUSAt%2BmXp876%2FNLpyt%0Afq20mSoOVd0cGeuKKKNCC861l69MLMe%2BSOHDsMmg8yWOqNtIiqST4QvZsDS4A8kaAMMCdNjcH0sh%0Aw58mwq7OcJiMu%2BDSuvMHAYiHSFRUwPBBALCXy90RyTnR4MzzOCj5mpEvBPEOsAaRm2IDus0gVw6%2F%0A2g%3D%3D|预订|54000D312511|D3125|NJH|IOQ|NJH|XOS|06:25|14:20|07:55|Y|KN6hW2fkkibAmuXBS8%2FPzYfLw456vwIjaKZXGUB2LL%2FF6dd5|20170729|3|HZ|01|21|1|0|||||||12||||有|无|||O0M0O0|OMO";
        TicketsInfo ti;
        try {
            ti = setTicket(s);
            System.out.println(ti);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("orderTicketsList.html")
    @AddLog("跳转通知列表页面")
    public String OrderTicketsListHtml(){
        return "ticket/orderTicketsList";
    }
    
    @RequestMapping("orderTicketsList.json")
    @ResponseBody
    public Map<String, Object> listJson(SysJob job,Page page){
        Map<String, Object> result = new HashMap<>();
        OrderTicketsExample example = new OrderTicketsExample();
        OrderTicketsExample.Criteria criteria = example.createCriteria();
        example.setPage(page);
        try {
            List<OrderTickets> list = orderTicketsService.selectByExample(example);
            int count = orderTicketsService.countByExample(example);
            result.put("rows", list);
            result.put("total", count);
            return result;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
    @RequestMapping("add.html")
    @AddLog("跳转新增通知页面")
    public String OrderTicketsAddHtml(){
        return "ticket/orderTicketsAdd";
    }
    
    @RequestMapping("add.json")
    @AddLog("新增通知")
    public String OrderTicketsAddJson(HttpServletRequest request, Map<String, Object> map, OrderTickets orderTickets,String date){
        try {
            SysUsers user = (SysUsers) request.getSession().getAttribute("user");
            orderTickets.setOrderUser(user.getUserAccount());
            orderTickets.setUpdateTime(new Date());
            orderTickets.setOrderDate(DateUtil.getDateByStr(date));
            Integer num = orderTicketsService.insertSelective(orderTickets);
            if(num >0){
                return "redirect:orderTicketsList.html";
            }
            map.put("error", "保存失败");
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return "ticket/orderTicketsAdd";
    }
    
    @RequestMapping("edit.html")
    @AddLog("跳转编辑通知页面")
    public String OrderTicketsEditHtml(Map<String, Object> map, Integer orderticketsId){
        try {
            OrderTickets ordertickets = orderTicketsService.selectByPrimaryKey(orderticketsId);
            map.put("info", ordertickets);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "ticket/orderTicketsEdit";
    }
    @RequestMapping("edit.json")
    @AddLog("编辑通知")
    public String OrderTicketsEditJson(HttpServletRequest request, Map<String, Object> map, OrderTickets orderTickets,String date){
        try {
            SysUsers user = (SysUsers) request.getSession().getAttribute("user");
            orderTickets.setOrderUser(user.getUserAccount());
            orderTickets.setUpdateTime(new Date());
            orderTickets.setOrderDate(DateUtil.getDateByStr(date));
            Integer num = orderTicketsService.updateByPrimaryKeySelective(orderTickets);
            if(num >0){
                return "redirect:orderTicketsList.html";
            }
            map.put("error", "保存失败");
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return "ticket/orderTicketsAdd";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    @AddLog("删除任务")
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<Integer >ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=orderTicketsService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
    
    @RequestMapping("list.html")
    @AddLog("跳转查票页面")
    public String listHtml(){
        return "ticket/ticketList";
    }
    
    @RequestMapping("getJson")
    @ResponseBody
    public List<TicketsInfo> getJson(String date, String startStation, String endStation){
        if (date == null || startStation == null || endStation == null || date.length() == 0
                || startStation.length() == 0 || endStation.length() == 0) {
        }
        final String  URL = "https://kyfw.12306.cn/otn/leftTicket/query";
        String from_station ="";
        String to_station ="";
        String queryDate = date;
        String sql = "select * from station where 1=1";
        StringBuffer sqlStart=new StringBuffer(sql);
        sqlStart.append(" and station_cn = ").append("'").append(startStation).append("'");
        List<Map<String, String>> startStationCn = SqLiteUtil.getRowValue(sqlStart.toString());
        if(startStationCn.size()>0){
            from_station = startStationCn.get(0).get("station_code");        
        }
        StringBuffer sqlEnd=new StringBuffer(sql);
        sqlEnd.append(" and station_cn = ").append("'");
        sqlEnd.append(endStation).append("'");
        List<Map<String, String>> endStationCn = SqLiteUtil.getRowValue(sqlEnd.toString());
        if(endStationCn.size()>0){
            to_station = endStationCn.get(0).get("station_code");        
        }
        
        String purpose_codes = "ADULT";
        String param ="leftTicketDTO.train_date=" + queryDate + "&leftTicketDTO.from_station=" + from_station
                + "&leftTicketDTO.to_station=" + to_station+ "&purpose_codes=" + purpose_codes ;
        logger.debug("访问参数："+param);
        try {
            String ssl=ResourceUtils.getURL("classpath:jssecacerts").getPath();
            System.setProperty("javax.net.ssl.trustStore", ssl);
        } catch (FileNotFoundException e) {
            logger.error("错误",e);
        }
        String json = HttpUtil.sendGet(URL, param);
        if(json.length()==0){
            return null;
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            JSONArray data =  jsonObject.getJSONObject("data").getJSONArray("result");
            List<TicketsInfo> tilist = new ArrayList<>();
            for(Object result :data){
                if(result.toString().contains("暂停发售")){
                    continue;
                }
                try {
                    tilist.add(setTicket(result.toString()));
                } catch (Exception e) {
                    logger.info(result.toString());
                    logger.error("Exception ", e);
                }
            }
            return tilist;
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
    private static TicketsInfo setTicket(String result) throws Exception{
        String[] arrays = result.split("\\|");
        TicketsInfo ti = new TicketsInfo(arrays[2],arrays[3],arrays[4],arrays[5],arrays[6],arrays[7],arrays[8],arrays[9],arrays[10],arrays[11],arrays[12],arrays[13],arrays[14],arrays[15],arrays[16],arrays[17]
                ,arrays[18],arrays[19],arrays[20],arrays[21],arrays[22],arrays[23],arrays[24],arrays[25],arrays[26],arrays[27],arrays[28],arrays[29],arrays[30],arrays[31],arrays[32],arrays[33],arrays[34]);
        return ti;
    }
}
