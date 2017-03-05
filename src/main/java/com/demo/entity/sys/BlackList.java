package com.demo.entity.sys;

import java.io.Serializable;
import java.math.BigDecimal;

public class BlackList implements Serializable {
    private BigDecimal id;

    private String blackuserId;

    private String remark;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getBlackuserId() {
        return blackuserId;
    }

    public void setBlackuserId(String blackuserId) {
        this.blackuserId = blackuserId == null ? null : blackuserId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}