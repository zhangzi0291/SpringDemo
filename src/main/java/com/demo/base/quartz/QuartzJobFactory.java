package com.demo.base.quartz;

import javax.annotation.Resource;

import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class QuartzJobFactory extends AdaptableJobFactory {
    
    private  Logger logger = LoggerFactory.getLogger(this.getClass());
  
    //这个对象Spring会帮我们自动注入进来,也属于Spring技术范畴.
    @Resource
    private AutowireCapableBeanFactory capableBeanFactory;
    
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入,这属于Spring的技术,不清楚的可以查看Spring的API.
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
    
}
