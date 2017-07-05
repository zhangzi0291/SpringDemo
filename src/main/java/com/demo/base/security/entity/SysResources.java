package com.demo.base.security.entity;

import java.io.Serializable;

public class SysResources implements Serializable {
    private String resourceId;

    private String resourceName;

    private String resourceDesc;

    private String resourceType;

    private String resourceString;

    private Integer priority;

    private Integer enabled;

    private Integer issys;

    private String module;

    private static final long serialVersionUID = 1L;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString == null ? null : resourceString.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getIssys() {
        return issys;
    }

    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }
}