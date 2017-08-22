package com.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.aspect.AddLogAspect;

public class MailUtil {
    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);
    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        sendMail("zhangzi0291@126.com", "测试","谢谢谢谢谢谢谢谢谢谢\ns的算法撒地方");
    }
    public static void sendMail(String receiveMail, String subject, String content) throws UnsupportedEncodingException, MessagingException {
        logger.debug("开始送信");
        Properties props = new Properties();  
        // 开启debug调试  
        //props.setProperty("mail.debug", "true");  
        // 发送服务器需要身份验证  
        props.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        props.setProperty("mail.smtp.host", "smtp.qq.com");  
        // 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.user", "466869790@qq.com");
        props.setProperty("mail.password", "yjhcphyobxencaeb");
        // 设置环境信息  
        Session session = Session.getInstance(props);  
        // 创建邮件对象  
        Message msg = createMimeMessage(session,"wesxc@qq.com", receiveMail);  
        msg.setSubject(subject);  
        // 设置邮件内容  
        msg.setText(content);  
        Transport transport = session.getTransport();  
        // 连接邮件服务器  
        transport.connect("smtp.qq.com",587,"wesxc@qq.com","yjhcphyobxencaeb");
        // 发送邮件  
        transport.sendMessage(msg, msg.getAllRecipients());  
        // 关闭连接  
        transport.close();  
        logger.debug("结束送信");
    }
    
    private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws UnsupportedEncodingException, MessagingException  {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "通知", "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "", "UTF-8"));
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }
}
