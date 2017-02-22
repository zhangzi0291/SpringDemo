package com.demo.entity.evaluation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EvaluationCriteria implements Serializable {
    private BigDecimal id;

    private String evaluatorsMan;

    private String valuationMan;

    private BigDecimal evaluationScore;

    private Date evaluationDate;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEvaluatorsMan() {
        return evaluatorsMan;
    }

    public void setEvaluatorsMan(String evaluatorsMan) {
        this.evaluatorsMan = evaluatorsMan == null ? null : evaluatorsMan.trim();
    }

    public String getValuationMan() {
        return valuationMan;
    }

    public void setValuationMan(String valuationMan) {
        this.valuationMan = valuationMan == null ? null : valuationMan.trim();
    }

    public BigDecimal getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(BigDecimal evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}