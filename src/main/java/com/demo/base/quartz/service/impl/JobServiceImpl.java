package com.demo.base.quartz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.Enum.JobState;
import com.demo.base.quartz.dao.SysJobDao;
import com.demo.base.quartz.entity.SysJob;
import com.demo.base.quartz.entity.SysJobExample;
import com.demo.base.quartz.service.JobService;

@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<SysJob, SysJobExample> implements JobService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysJobDao dao;
//    @Resource
//    private SchedulerFactoryBean schedulerFactoryBean;
    @Resource
    private Scheduler scheduler;
    
    @Override
    public BaseDao<SysJob, SysJobExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public String addJob(SysJob job) {
//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                Class clazz =  Class.forName(job.getJobClass());
                // 4、org.quartz.JobBuilder.newJob --通过JobBuilder构建Job JobBuilder无构造函数，所以只能通过JobBuilder的静态方法newJob(Class<? extends Job> jobClass)生成JobBuilder实例
                //withIdentity(String name,String group)参数用来定义jobKey，如果不设置，也会自动生成一个独一无二的jobKey用来区分不同的job  
                JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch(IllegalArgumentException e){
            logger.error("-------------------------job Class未实现Job接口-------------------------");
            logger.error("Exception ", e);
            job.setJobStatus(JobState.ERROR.toString());
            return "job Class未实现Job接口";
        } catch (ClassNotFoundException e) {
            logger.error("-------------------------job Class未找到-------------------------");
            logger.error("Exception ", e);
            return "job Class未找到";
        } catch (SchedulerException e) {
            logger.error("-------------------------job 表达式异常-------------------------");
            logger.error("Exception ", e);
            return "job 表达式异常";
        }
        job.setJobStatus(JobState.RUN.toString());
        dao.insertSelective(job);
        return "";
    }

    @Override
    public String updateJob(SysJob job) {
        if(job.getJobId()==null){
            logger.error("没有任务id");
            return "没有任务id";
        }
//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                Class clazz =  Class.forName(job.getJobClass());
                // 4、org.quartz.JobBuilder.newJob --通过JobBuilder构建Job JobBuilder无构造函数，所以只能通过JobBuilder的静态方法newJob(Class<? extends Job> jobClass)生成JobBuilder实例
                //withIdentity(String name,String group)参数用来定义jobKey，如果不设置，也会自动生成一个独一无二的jobKey用来区分不同的job  
                JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        }catch(IllegalArgumentException e){
            logger.error("-------------------------job Class未实现Job接口-------------------------");
            logger.error("Exception ", e);
            job.setJobStatus(JobState.ERROR.toString());
            return "job Class未实现Job接口";
        }catch (ClassNotFoundException e) {
            logger.error("-------------------------job Class未找到-------------------------");
            logger.error("Exception ", e);
            job.setJobStatus(JobState.ERROR.toString());
            return "job Class未找到";
        } catch (SchedulerException e) {
            logger.error("-------------------------job 表达式异常-------------------------");
            logger.error("Exception ", e);
            job.setJobStatus(JobState.ERROR.toString());
            return "job 表达式异常";
        }
        job.setJobStatus(JobState.RUN.toString());
        dao.updateByPrimaryKeySelective(job);
        return "";
    }

    @Override
    public List<String> removeJob(List<Integer >ids) {
        Integer num = 0;
        List<String > errorlist = new ArrayList<>();
        for(int i=0;i<ids.size();i++){
            SysJob job = dao.selectByPrimaryKey(ids.get(i));
            if(stopJob(job)){
                num+=dao.deleteByPrimaryKey(ids.get(i));
                continue;
            }
            logger.error("不能停止任务无法删除");
            errorlist.add(job.getJobName());
        }
        return errorlist;
    }

    @Override
    public boolean stopJob(SysJob job) {
        try {
//            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
            scheduler.pauseJob(jobKey);
            job.setJobStatus(JobState.STOP.toString());
            job.setJobEndtime(new Date());
            dao.updateByPrimaryKeySelective(job);
        } catch (Exception e) {
            logger.error("Exception ", e);
            return false;
        }
        return true;
    }

}
