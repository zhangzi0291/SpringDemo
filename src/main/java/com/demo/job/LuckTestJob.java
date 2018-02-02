package com.demo.job;


import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.util.MailUtil;

public class LuckTestJob implements Job{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Random r = new Random();
        try {
            if((r.nextDouble()*100)>95) {
                MailUtil.sendMail("466869790@qq.com", "今天运气不错", "运气不错");
            }else if((r.nextDouble()*100)<10) {
                MailUtil.sendMail("466869790@qq.com", "今天运气很差", "运气很差");
            }
        } catch (UnsupportedEncodingException | MessagingException e) {
            logger.error("Exception ", e);
        }
    }

}
