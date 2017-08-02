package com.demo.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DaoException;
import com.demo.base.Page;
import com.demo.base.Enum.JobState;
import com.demo.base.quartz.entity.SysJob;
import com.demo.base.quartz.entity.SysJobExample;
import com.demo.base.quartz.service.JobService;
import com.demo.util.StringUtil;

@Controller
@RequestMapping("job")
public class JobController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private JobService jobService;
    
    @PostConstruct
    public void initTask(){
        //查询任务表，如果存在正在执行中的任务，启动该任务
        SysJobExample jobExample = new SysJobExample();
        SysJobExample.Criteria jobCri = jobExample.createCriteria();
        jobCri.andJobStatusEqualTo(JobState.RUN.toString());
        try {
            List<SysJob> jobs = jobService.selectByExample(jobExample);
            for (SysJob sysJob : jobs) {
                if(StringUtil.isEmpty(jobService.updateJob(sysJob))){
                    continue;
                }
                logger.warn(sysJob.getJobGroup()+"--"+sysJob.getJobName()+":启动失败");
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        
    }
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "sys/job/jobList";
    }
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(SysJob job,Page page){
        Map<String, Object> result = new HashMap<>();
        SysJobExample example = new SysJobExample();
        SysJobExample.Criteria criteria = example.createCriteria();
        example.setPage(page);
        try {
            List<SysJob> list = jobService.selectByExample(example);
            int count = jobService.countByExample(example);
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
        return "sys/job/jobAdd";
    }
    @RequestMapping("add.json")
    public String addJson(Map<String, Object> map, SysJob job){
        try {
            String result = jobService.addJob(job);
            if(StringUtil.isEmpty(result)){
                return "redirect:list.html";
            }
            map.put("error", result);
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return "sys/job/jobAdd";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, Integer jobId){
        try {
            SysJob job = jobService.selectByPrimaryKey(jobId);
            map.put("info", job);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "sys/job/jobEdit";
    }
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, SysJob job){
        try {
            String result = jobService.updateJob(job);
            if(StringUtil.isEmpty(result)){
                return "redirect:list.html";
            }
            map.put("error", result);
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        map.put("info", job);
        return "sys/job/jobEdit";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    public List<String> delJson(Map<String, Object> map, @RequestParam("ids[]") List<Integer >ids ){
        List<String> errorlist = jobService.removeJob(ids);
        return errorlist;
    }
    
    @RequestMapping("stopJob")
    @ResponseBody
    public String stopJob (Integer jobId){
       try {
           SysJob job =  jobService.selectByPrimaryKey(jobId);
           Boolean b = jobService.stopJob(job);
           return b.toString();
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
       return null;
    }
    @RequestMapping("startJob")
    @ResponseBody
    public String startJob (Integer jobId){
        try {
            SysJob job =  jobService.selectByPrimaryKey(jobId);
            String result = jobService.updateJob(job);
            return result;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
}
