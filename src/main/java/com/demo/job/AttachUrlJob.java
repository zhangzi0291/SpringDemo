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

import com.demo.base.exception.DaoException;
import com.demo.controller.TrainTicketsController;
import com.demo.entity.BoAttachUrl;
import com.demo.entity.BoAttachUrlExample;
import com.demo.entity.ticket.OrderTickets;
import com.demo.entity.ticket.OrderTicketsExample;
import com.demo.entity.ticket.TicketsInfo;
import com.demo.service.BoAttachUrlService;
import com.demo.service.OrderTicketsService;
import com.demo.util.HttpUtil;
import com.demo.util.MailUtil;
import com.demo.util.StringUtil;

public class AttachUrlJob implements Job{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private BoAttachUrlService boAttachUrlService;
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            BoAttachUrlExample example = new BoAttachUrlExample();
            BoAttachUrlExample.Criteria criteria = example.createCriteria();
            criteria.andAttachStatusEqualTo("1");
            List<BoAttachUrl> list = boAttachUrlService.selectByExample(example);
            for(BoAttachUrl attachUrl : list) {
                if(!HttpUtil.isConnect(attachUrl.getAttachUrl())) {
                    String info = attachUrl.getAttachUrl() + " 服务器挂啦";
                    MailUtil.sendMail(attachUrl.getAttachEmail(), "服务器挂啦", info);
                }
            }
        } catch (UnsupportedEncodingException | DaoException | MessagingException e) {
            logger.error("Exception ", e);
        }
    }


}
