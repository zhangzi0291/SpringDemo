package com.demo.job;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.base.DaoException;
import com.demo.controller.TrainTicketsController;
import com.demo.entity.ticket.OrderTickets;
import com.demo.entity.ticket.OrderTicketsExample;
import com.demo.entity.ticket.TicketsInfo;
import com.demo.service.OrderTicketsService;
import com.demo.util.MailUtil;
import com.demo.util.StringUtil;

public class TrainTicketsJob implements Job{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private OrderTicketsService orderTicketsService;
    @Resource
    private TrainTicketsController trainTicketsController;
    private static List<TicketsInfo> ticketList = null;
    private static StringBuffer info = new StringBuffer();
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            OrderTicketsExample example = new OrderTicketsExample();
            List<OrderTickets> list = orderTicketsService.selectByExample(example);
            if(list.size()>0){
                list.forEach(orderTickets -> {
                    ZoneId zone = ZoneId.systemDefault();
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(orderTickets.getOrderDate().toInstant(), zone);
                    LocalDate date = localDateTime.toLocalDate();
                    ticketList = trainTicketsController.getJson(date.toString(), orderTickets.getFromStation(), orderTickets.getToStation());
                    if(ticketList != null && ticketList.size()>0){
                        ticketList.forEach(ticket -> {
                            if(!checkTrainTicke(ticket)){
                                return;
                            }
                            info .append(getTrainTicketInfo(ticket));
                        });
                        info.insert(0,"信息如下\n\n");
                        info.append("\n");
                        try {
                            MailUtil.sendMail(orderTickets.getEmailAddress(), "可以订票啦", info.toString());
                        } catch (UnsupportedEncodingException | MessagingException e) {
                            logger.error("发送email出错");
                            logger.error("Exception ", e);
                        }
                    }
                    ticketList = new ArrayList<>();
                    info = new StringBuffer();
                });
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
            e.printStackTrace();
        }
    }

    private String  getTrainTicketInfo(TicketsInfo ticket){
        StringBuffer result = new StringBuffer();
        result.append("车次:").append(ticket.getStationTrainCode()).append(", ");
        result.append("始发站:").append(ticket.getStartStationTelecode()).append(", ");
        result.append("终点站:").append(ticket.getEndStationTelecode()).append(", ");
        result.append("出发时间:").append(ticket.getStartTime()).append(", ");
        result.append("到达时间:").append(ticket.getArriveTime()).append(", \n");
        if(StringUtil.isNotEmpty(ticket.getRwNum())){
            result.append("软卧:").append(ticket.getRwNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getRzNum())){
            result.append("软座:").append(ticket.getRzNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getWzNum())){
            result.append("无座:").append(ticket.getWzNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getYzNum())){
            result.append("硬座:").append(ticket.getYzNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getYwNum())){
            result.append("硬卧:").append(ticket.getYwNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getZyNum())){
            result.append("一等座:").append(ticket.getZyNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getZeNum())){
            result.append("二等座:").append(ticket.getZeNum()).append(" , ");
        }
        if(StringUtil.isNotEmpty(ticket.getSwzNum())){
            result.append("商务座:").append(ticket.getSwzNum()).append(" ,");
        }
        result.append("\n");
        result.append("\n");
        return result.toString();
    }
    
    /**
     * 
      * 检查是否有票，有票true
      *@param ticket
      *@return 
      *@date 2017年8月18日 上午10:38:30
      *@author zxn
     */
    public boolean checkTrainTicke(TicketsInfo ticket){
        boolean all = false;
        boolean rw = StringUtil.isNotEmpty(ticket.getRwNum());
        boolean rwNum = !ticket.getRwNum().contains("无");
        boolean rz = StringUtil.isNotEmpty(ticket.getRzNum());
        boolean rzNum = !ticket.getRzNum().contains("无");
        boolean wz = StringUtil.isNotEmpty(ticket.getWzNum());
        boolean wzNum = !ticket.getWzNum().contains("无");
        boolean yz = StringUtil.isNotEmpty(ticket.getYzNum());
        boolean yzNum = !ticket.getYzNum().contains("无");
        boolean yw = StringUtil.isNotEmpty(ticket.getYwNum());
        boolean ywNum = !ticket.getYwNum().contains("无");
        boolean zy = StringUtil.isNotEmpty(ticket.getZyNum());
        boolean zyNum = !ticket.getZyNum().contains("无");
        boolean ze = StringUtil.isNotEmpty(ticket.getZeNum());
        boolean zeNum = !ticket.getZeNum().contains("无");
        boolean swz = StringUtil.isNotEmpty(ticket.getSwzNum());
        boolean swzNum = !ticket.getSwzNum().contains("无");
        if(rw){
            all = all||rwNum;
        }
        if(rz){
            all = all||rzNum;
        }
        if(wz){
            all = all||wzNum;
        }
        if(yz){
            all = all||yzNum;
        }
        if(yw){
            all = all||ywNum;
        }
        if(zy){
            all = all||zeNum;
        }
        if(ze){
            all = all||zyNum;
        }
        if(swz){
            all = all||swzNum;
        }
        return all;
    }
}
