package com.demo.base.security.entity;

import java.io.Serializable;

public class SysRolesAuthorities implements Serializable {
    private Integer id;

    private String roleId;

    private String authorityId;

    private Integer enabled;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}