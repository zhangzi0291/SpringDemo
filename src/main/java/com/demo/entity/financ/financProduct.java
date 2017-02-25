package com.demo.entity.financ;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.demo.base.DaoException;
import com.demo.entity.sys.SysUser;
import com.demo.service.sys.UserService;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

public class financProduct implements Serializable {
	
    private BigDecimal id;

    private BigDecimal loanAmount;

    private String repaymentMethod;

    private BigDecimal interestRate;

    private Date repaymentDate;

    private String publicType;

    private String publicMan;
    
    private String publicManStr;

    private BigDecimal repaymentBalance;

    private String repaymentMan;
    
    private String repaymentManStr;

    private String state;

    private String stateStr;
    
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

	public String getRepaymentDateStr() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(repaymentDate);
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getPublicManStr() {
		return publicManStr;
	}

	public void setPublicManStr(String publicManStr) {
		this.publicManStr = publicManStr;
	}

	public String getRepaymentManStr() {
		return repaymentManStr;
	}

	public void setRepaymentManStr(String repaymentManStr) {
		this.repaymentManStr = repaymentManStr;
	}

	public String getStateStr() {
		switch (state) {
		case "1":
			return "发布融资";
		case "2":
			return "申请贷款";
		case "3":
			return "审核通过";
		case "4":
			return "审核不通过";
		case "5":
			return "正在还款";
		case "6":
			return "还款结束";
		case "7":
			return "交易完成";
		case "8":
			return "发布贷款申请";
		case "9":
			return "融资人评价完成";
		case "10":
			return "贷款人评价完成";

		default:
			break;
		}
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
    
}