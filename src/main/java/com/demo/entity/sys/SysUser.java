package com.demo.entity.sys;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysUser implements Serializable {
    private BigDecimal id;

    private String userName;

    private String userPwd;

    private String userEmail;

    private String userProfession;

    private String realName;

    private BigDecimal realIncome;

    private BigDecimal familyNumber;

    private String idNumber;

    private String creditRate;

    private String headshotImg;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession == null ? null : userProfession.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public BigDecimal getRealIncome() {
        return realIncome;
    }

    public void setRealIncome(BigDecimal realIncome) {
        this.realIncome = realIncome;
    }

    public BigDecimal getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(BigDecimal familyNumber) {
        this.familyNumber = familyNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(String creditRate) {
        this.creditRate = creditRate == null ? null : creditRate.trim();
    }

    public String getHeadshotImg() {
        return headshotImg;
    }

    public void setHeadshotImg(String headshotImg) {
        this.headshotImg = headshotImg == null ? null : headshotImg.trim();
    }
}