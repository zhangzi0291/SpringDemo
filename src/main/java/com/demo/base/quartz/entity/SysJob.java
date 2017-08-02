package com.demo.base.quartz.entity;

import java.io.Serializable;
import java.util.Date;

public class SysJob implements Serializable {
    private Integer jobId;

    private String jobName;

    private String jobGroup;

    private String jobStatus;

    private String cronExpression;

    private String jobDesc;

    private String jobClass;

    private Date jobStarttime;

    private Date jobEndtime;

    private static final long serialVersionUID = 1L;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc == null ? null : jobDesc.trim();
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass == null ? null : jobClass.trim();
    }

    public Date getJobStarttime() {
        return jobStarttime;
    }

    public void setJobStarttime(Date jobStarttime) {
        this.jobStarttime = jobStarttime;
    }

    public Date getJobEndtime() {
        return jobEndtime;
    }

    public void setJobEndtime(Date jobEndtime) {
        this.jobEndtime = jobEndtime;
    }
}