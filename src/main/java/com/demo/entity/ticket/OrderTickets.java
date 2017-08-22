package com.demo.entity.ticket;

import java.io.Serializable;
import java.util.Date;

public class OrderTickets implements Serializable {
    private Integer orderticketsId;

    private String orderUser;

    private String fromStation;

    private String toStation;

    private Date orderDate;

    private Date updateTime;

    private String emailAddress;

    private static final long serialVersionUID = 1L;

    public Integer getOrderticketsId() {
        return orderticketsId;
    }

    public void setOrderticketsId(Integer orderticketsId) {
        this.orderticketsId = orderticketsId;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser == null ? null : orderUser.trim();
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation == null ? null : fromStation.trim();
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation == null ? null : toStation.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    @Override
    public String toString() {
        return "OrderTickets [orderticketsId=" + orderticketsId + ", orderUser=" + orderUser + ", fromStation="
                + fromStation + ", toStation=" + toStation + ", orderDate=" + orderDate + ", updateTime=" + updateTime
                + ", emailAddress=" + emailAddress + "]";
    }
    
}