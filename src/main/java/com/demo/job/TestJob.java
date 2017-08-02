package com.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

    static Integer num = 0;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(num++);
    }

}
