package com.demo.base.quartz.service;

import java.util.List;

import com.demo.base.BaseService;
import com.demo.base.quartz.entity.SysJob;
import com.demo.base.quartz.entity.SysJobExample;

public interface JobService extends BaseService<SysJob, SysJobExample>{

    String addJob(SysJob job);
    String updateJob(SysJob job);
    List<String> removeJob(List<Integer >ids);
    boolean stopJob(SysJob job);
}
