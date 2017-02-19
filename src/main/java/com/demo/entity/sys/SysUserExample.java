package com.demo.entity.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class SysUserExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USER_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USER_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USER_PWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USER_PWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USER_PWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USER_PWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_PWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USER_PWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USER_PWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USER_PWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USER_PWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USER_PWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USER_PWD not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserProfessionIsNull() {
            addCriterion("USER_PROFESSION is null");
            return (Criteria) this;
        }

        public Criteria andUserProfessionIsNotNull() {
            addCriterion("USER_PROFESSION is not null");
            return (Criteria) this;
        }

        public Criteria andUserProfessionEqualTo(String value) {
            addCriterion("USER_PROFESSION =", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionNotEqualTo(String value) {
            addCriterion("USER_PROFESSION <>", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionGreaterThan(String value) {
            addCriterion("USER_PROFESSION >", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PROFESSION >=", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionLessThan(String value) {
            addCriterion("USER_PROFESSION <", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionLessThanOrEqualTo(String value) {
            addCriterion("USER_PROFESSION <=", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionLike(String value) {
            addCriterion("USER_PROFESSION like", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionNotLike(String value) {
            addCriterion("USER_PROFESSION not like", value, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionIn(List<String> values) {
            addCriterion("USER_PROFESSION in", values, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionNotIn(List<String> values) {
            addCriterion("USER_PROFESSION not in", values, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionBetween(String value1, String value2) {
            addCriterion("USER_PROFESSION between", value1, value2, "userProfession");
            return (Criteria) this;
        }

        public Criteria andUserProfessionNotBetween(String value1, String value2) {
            addCriterion("USER_PROFESSION not between", value1, value2, "userProfession");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("REAL_NAME <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("REAL_NAME like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("REAL_NAME not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealIncomeIsNull() {
            addCriterion("REAL_INCOME is null");
            return (Criteria) this;
        }

        public Criteria andRealIncomeIsNotNull() {
            addCriterion("REAL_INCOME is not null");
            return (Criteria) this;
        }

        public Criteria andRealIncomeEqualTo(BigDecimal value) {
            addCriterion("REAL_INCOME =", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeNotEqualTo(BigDecimal value) {
            addCriterion("REAL_INCOME <>", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeGreaterThan(BigDecimal value) {
            addCriterion("REAL_INCOME >", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_INCOME >=", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeLessThan(BigDecimal value) {
            addCriterion("REAL_INCOME <", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_INCOME <=", value, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeIn(List<BigDecimal> values) {
            addCriterion("REAL_INCOME in", values, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeNotIn(List<BigDecimal> values) {
            addCriterion("REAL_INCOME not in", values, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_INCOME between", value1, value2, "realIncome");
            return (Criteria) this;
        }

        public Criteria andRealIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_INCOME not between", value1, value2, "realIncome");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberIsNull() {
            addCriterion("FAMILY_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberIsNotNull() {
            addCriterion("FAMILY_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberEqualTo(BigDecimal value) {
            addCriterion("FAMILY_NUMBER =", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberNotEqualTo(BigDecimal value) {
            addCriterion("FAMILY_NUMBER <>", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberGreaterThan(BigDecimal value) {
            addCriterion("FAMILY_NUMBER >", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAMILY_NUMBER >=", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberLessThan(BigDecimal value) {
            addCriterion("FAMILY_NUMBER <", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAMILY_NUMBER <=", value, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberIn(List<BigDecimal> values) {
            addCriterion("FAMILY_NUMBER in", values, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberNotIn(List<BigDecimal> values) {
            addCriterion("FAMILY_NUMBER not in", values, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAMILY_NUMBER between", value1, value2, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAMILY_NUMBER not between", value1, value2, "familyNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("ID_NUMBER =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("ID_NUMBER <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("ID_NUMBER >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("ID_NUMBER <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("ID_NUMBER like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("ID_NUMBER not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("ID_NUMBER in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("ID_NUMBER not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("ID_NUMBER between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("ID_NUMBER not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNull() {
            addCriterion("CREDIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNotNull() {
            addCriterion("CREDIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRateEqualTo(String value) {
            addCriterion("CREDIT_RATE =", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotEqualTo(String value) {
            addCriterion("CREDIT_RATE <>", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThan(String value) {
            addCriterion("CREDIT_RATE >", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_RATE >=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThan(String value) {
            addCriterion("CREDIT_RATE <", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_RATE <=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLike(String value) {
            addCriterion("CREDIT_RATE like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotLike(String value) {
            addCriterion("CREDIT_RATE not like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateIn(List<String> values) {
            addCriterion("CREDIT_RATE in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotIn(List<String> values) {
            addCriterion("CREDIT_RATE not in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateBetween(String value1, String value2) {
            addCriterion("CREDIT_RATE between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotBetween(String value1, String value2) {
            addCriterion("CREDIT_RATE not between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgIsNull() {
            addCriterion("HEADSHOT_IMG is null");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgIsNotNull() {
            addCriterion("HEADSHOT_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgEqualTo(String value) {
            addCriterion("HEADSHOT_IMG =", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgNotEqualTo(String value) {
            addCriterion("HEADSHOT_IMG <>", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgGreaterThan(String value) {
            addCriterion("HEADSHOT_IMG >", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgGreaterThanOrEqualTo(String value) {
            addCriterion("HEADSHOT_IMG >=", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgLessThan(String value) {
            addCriterion("HEADSHOT_IMG <", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgLessThanOrEqualTo(String value) {
            addCriterion("HEADSHOT_IMG <=", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgLike(String value) {
            addCriterion("HEADSHOT_IMG like", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgNotLike(String value) {
            addCriterion("HEADSHOT_IMG not like", value, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgIn(List<String> values) {
            addCriterion("HEADSHOT_IMG in", values, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgNotIn(List<String> values) {
            addCriterion("HEADSHOT_IMG not in", values, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgBetween(String value1, String value2) {
            addCriterion("HEADSHOT_IMG between", value1, value2, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgNotBetween(String value1, String value2) {
            addCriterion("HEADSHOT_IMG not between", value1, value2, "headshotImg");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(USER_NAME) like", value.toUpperCase(), "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdLikeInsensitive(String value) {
            addCriterion("upper(USER_PWD) like", value.toUpperCase(), "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserEmailLikeInsensitive(String value) {
            addCriterion("upper(USER_EMAIL) like", value.toUpperCase(), "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserProfessionLikeInsensitive(String value) {
            addCriterion("upper(USER_PROFESSION) like", value.toUpperCase(), "userProfession");
            return (Criteria) this;
        }

        public Criteria andRealNameLikeInsensitive(String value) {
            addCriterion("upper(REAL_NAME) like", value.toUpperCase(), "realName");
            return (Criteria) this;
        }

        public Criteria andIdNumberLikeInsensitive(String value) {
            addCriterion("upper(ID_NUMBER) like", value.toUpperCase(), "idNumber");
            return (Criteria) this;
        }

        public Criteria andCreditRateLikeInsensitive(String value) {
            addCriterion("upper(CREDIT_RATE) like", value.toUpperCase(), "creditRate");
            return (Criteria) this;
        }

        public Criteria andHeadshotImgLikeInsensitive(String value) {
            addCriterion("upper(HEADSHOT_IMG) like", value.toUpperCase(), "headshotImg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}