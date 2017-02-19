package com.demo.entity.financ;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class financProduct implements Serializable {
    private BigDecimal id;

    private BigDecimal loanAmount;

    private String repaymentMethod;

    private BigDecimal interestRate;

    private Date repaymentDate;

    private String publicType;

    private String publicMan;

    private BigDecimal repaymentBalance;

    private String repaymentMan;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod == null ? null : repaymentMethod.trim();
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getPublicType() {
        return publicType;
    }

    public void setPublicType(String publicType) {
        this.publicType = publicType == null ? null : publicType.trim();
    }

    public String getPublicMan() {
        return publicMan;
    }

    public void setPublicMan(String publicMan) {
        this.publicMan = publicMan == null ? null : publicMan.trim();
    }

    public BigDecimal getRepaymentBalance() {
        return repaymentBalance;
    }

    public void setRepaymentBalance(BigDecimal repaymentBalance) {
        this.repaymentBalance = repaymentBalance;
    }

    public String getRepaymentMan() {
        return repaymentMan;
    }

    public void setRepaymentMan(String repaymentMan) {
        this.repaymentMan = repaymentMan == null ? null : repaymentMan.trim();
    }
}