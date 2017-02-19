package com.demo.entity.financ;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class financProductExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public financProductExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andLoanAmountIsNull() {
            addCriterion("LOAN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("LOAN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(BigDecimal value) {
            addCriterion("LOAN_AMOUNT >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_AMOUNT <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMOUNT in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_AMOUNT not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMOUNT between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_AMOUNT not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodIsNull() {
            addCriterion("REPAYMENT_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodIsNotNull() {
            addCriterion("REPAYMENT_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodEqualTo(String value) {
            addCriterion("REPAYMENT_METHOD =", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodNotEqualTo(String value) {
            addCriterion("REPAYMENT_METHOD <>", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodGreaterThan(String value) {
            addCriterion("REPAYMENT_METHOD >", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("REPAYMENT_METHOD >=", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodLessThan(String value) {
            addCriterion("REPAYMENT_METHOD <", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("REPAYMENT_METHOD <=", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodLike(String value) {
            addCriterion("REPAYMENT_METHOD like", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodNotLike(String value) {
            addCriterion("REPAYMENT_METHOD not like", value, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodIn(List<String> values) {
            addCriterion("REPAYMENT_METHOD in", values, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodNotIn(List<String> values) {
            addCriterion("REPAYMENT_METHOD not in", values, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodBetween(String value1, String value2) {
            addCriterion("REPAYMENT_METHOD between", value1, value2, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodNotBetween(String value1, String value2) {
            addCriterion("REPAYMENT_METHOD not between", value1, value2, "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNull() {
            addCriterion("INTEREST_RATE is null");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNotNull() {
            addCriterion("INTEREST_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andInterestRateEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE =", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE <>", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThan(BigDecimal value) {
            addCriterion("INTEREST_RATE >", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE >=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThan(BigDecimal value) {
            addCriterion("INTEREST_RATE <", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE <=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateIn(List<BigDecimal> values) {
            addCriterion("INTEREST_RATE in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("INTEREST_RATE not in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_RATE between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_RATE not between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateIsNull() {
            addCriterion("REPAYMENT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateIsNotNull() {
            addCriterion("REPAYMENT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateEqualTo(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE =", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE <>", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE >", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE >=", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateLessThan(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE <", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REPAYMENT_DATE <=", value, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateIn(List<Date> values) {
            addCriterionForJDBCDate("REPAYMENT_DATE in", values, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("REPAYMENT_DATE not in", values, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REPAYMENT_DATE between", value1, value2, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REPAYMENT_DATE not between", value1, value2, "repaymentDate");
            return (Criteria) this;
        }

        public Criteria andPublicTypeIsNull() {
            addCriterion("PUBLIC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPublicTypeIsNotNull() {
            addCriterion("PUBLIC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPublicTypeEqualTo(String value) {
            addCriterion("PUBLIC_TYPE =", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeNotEqualTo(String value) {
            addCriterion("PUBLIC_TYPE <>", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeGreaterThan(String value) {
            addCriterion("PUBLIC_TYPE >", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLIC_TYPE >=", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeLessThan(String value) {
            addCriterion("PUBLIC_TYPE <", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeLessThanOrEqualTo(String value) {
            addCriterion("PUBLIC_TYPE <=", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeLike(String value) {
            addCriterion("PUBLIC_TYPE like", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeNotLike(String value) {
            addCriterion("PUBLIC_TYPE not like", value, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeIn(List<String> values) {
            addCriterion("PUBLIC_TYPE in", values, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeNotIn(List<String> values) {
            addCriterion("PUBLIC_TYPE not in", values, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeBetween(String value1, String value2) {
            addCriterion("PUBLIC_TYPE between", value1, value2, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicTypeNotBetween(String value1, String value2) {
            addCriterion("PUBLIC_TYPE not between", value1, value2, "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicManIsNull() {
            addCriterion("PUBLIC_MAN is null");
            return (Criteria) this;
        }

        public Criteria andPublicManIsNotNull() {
            addCriterion("PUBLIC_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andPublicManEqualTo(String value) {
            addCriterion("PUBLIC_MAN =", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManNotEqualTo(String value) {
            addCriterion("PUBLIC_MAN <>", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManGreaterThan(String value) {
            addCriterion("PUBLIC_MAN >", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLIC_MAN >=", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManLessThan(String value) {
            addCriterion("PUBLIC_MAN <", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManLessThanOrEqualTo(String value) {
            addCriterion("PUBLIC_MAN <=", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManLike(String value) {
            addCriterion("PUBLIC_MAN like", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManNotLike(String value) {
            addCriterion("PUBLIC_MAN not like", value, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManIn(List<String> values) {
            addCriterion("PUBLIC_MAN in", values, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManNotIn(List<String> values) {
            addCriterion("PUBLIC_MAN not in", values, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManBetween(String value1, String value2) {
            addCriterion("PUBLIC_MAN between", value1, value2, "publicMan");
            return (Criteria) this;
        }

        public Criteria andPublicManNotBetween(String value1, String value2) {
            addCriterion("PUBLIC_MAN not between", value1, value2, "publicMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceIsNull() {
            addCriterion("REPAYMENT_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceIsNotNull() {
            addCriterion("REPAYMENT_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE =", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceNotEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE <>", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceGreaterThan(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE >", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE >=", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceLessThan(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE <", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REPAYMENT_BALANCE <=", value, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceIn(List<BigDecimal> values) {
            addCriterion("REPAYMENT_BALANCE in", values, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceNotIn(List<BigDecimal> values) {
            addCriterion("REPAYMENT_BALANCE not in", values, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAYMENT_BALANCE between", value1, value2, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REPAYMENT_BALANCE not between", value1, value2, "repaymentBalance");
            return (Criteria) this;
        }

        public Criteria andRepaymentManIsNull() {
            addCriterion("REPAYMENT_MAN is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentManIsNotNull() {
            addCriterion("REPAYMENT_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentManEqualTo(String value) {
            addCriterion("REPAYMENT_MAN =", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManNotEqualTo(String value) {
            addCriterion("REPAYMENT_MAN <>", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManGreaterThan(String value) {
            addCriterion("REPAYMENT_MAN >", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManGreaterThanOrEqualTo(String value) {
            addCriterion("REPAYMENT_MAN >=", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManLessThan(String value) {
            addCriterion("REPAYMENT_MAN <", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManLessThanOrEqualTo(String value) {
            addCriterion("REPAYMENT_MAN <=", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManLike(String value) {
            addCriterion("REPAYMENT_MAN like", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManNotLike(String value) {
            addCriterion("REPAYMENT_MAN not like", value, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManIn(List<String> values) {
            addCriterion("REPAYMENT_MAN in", values, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManNotIn(List<String> values) {
            addCriterion("REPAYMENT_MAN not in", values, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManBetween(String value1, String value2) {
            addCriterion("REPAYMENT_MAN between", value1, value2, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManNotBetween(String value1, String value2) {
            addCriterion("REPAYMENT_MAN not between", value1, value2, "repaymentMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentMethodLikeInsensitive(String value) {
            addCriterion("upper(REPAYMENT_METHOD) like", value.toUpperCase(), "repaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPublicTypeLikeInsensitive(String value) {
            addCriterion("upper(PUBLIC_TYPE) like", value.toUpperCase(), "publicType");
            return (Criteria) this;
        }

        public Criteria andPublicManLikeInsensitive(String value) {
            addCriterion("upper(PUBLIC_MAN) like", value.toUpperCase(), "publicMan");
            return (Criteria) this;
        }

        public Criteria andRepaymentManLikeInsensitive(String value) {
            addCriterion("upper(REPAYMENT_MAN) like", value.toUpperCase(), "repaymentMan");
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