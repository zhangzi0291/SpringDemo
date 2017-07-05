package com.demo.base.security.entity;

import java.io.Serializable;

public class SysAuthorities implements Serializable {
    private String authorityId;

    private String authorityName;

    private String authorityDesc;

    private Integer enabled;

    private String module;

    private static final long serialVersionUID = 1L;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc == null ? null : authorityDesc.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }
}