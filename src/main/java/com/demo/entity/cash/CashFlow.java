package com.demo.entity.cash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CashFlow implements Serializable {
    private BigDecimal id;

    private String payeeMan;

    private String payerMan;

    private BigDecimal money;

    private Date payDate;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPayeeMan() {
        return payeeMan;
    }

    public void setPayeeMan(String payeeMan) {
        this.payeeMan = payeeMan == null ? null : payeeMan.trim();
    }

    public String getPayerMan() {
        return payerMan;
    }

    public void setPayerMan(String payerMan) {
        this.payerMan = payerMan == null ? null : payerMan.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}