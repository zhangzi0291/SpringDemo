package com.demo.entity.cash;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class CashFlowExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CashFlowExample() {
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

        public Criteria andPayeeManIsNull() {
            addCriterion("PAYEE_MAN is null");
            return (Criteria) this;
        }

        public Criteria andPayeeManIsNotNull() {
            addCriterion("PAYEE_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeManEqualTo(String value) {
            addCriterion("PAYEE_MAN =", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManNotEqualTo(String value) {
            addCriterion("PAYEE_MAN <>", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManGreaterThan(String value) {
            addCriterion("PAYEE_MAN >", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_MAN >=", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManLessThan(String value) {
            addCriterion("PAYEE_MAN <", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_MAN <=", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManLike(String value) {
            addCriterion("PAYEE_MAN like", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManNotLike(String value) {
            addCriterion("PAYEE_MAN not like", value, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManIn(List<String> values) {
            addCriterion("PAYEE_MAN in", values, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManNotIn(List<String> values) {
            addCriterion("PAYEE_MAN not in", values, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManBetween(String value1, String value2) {
            addCriterion("PAYEE_MAN between", value1, value2, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayeeManNotBetween(String value1, String value2) {
            addCriterion("PAYEE_MAN not between", value1, value2, "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayerManIsNull() {
            addCriterion("PAYER_MAN is null");
            return (Criteria) this;
        }

        public Criteria andPayerManIsNotNull() {
            addCriterion("PAYER_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andPayerManEqualTo(String value) {
            addCriterion("PAYER_MAN =", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManNotEqualTo(String value) {
            addCriterion("PAYER_MAN <>", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManGreaterThan(String value) {
            addCriterion("PAYER_MAN >", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_MAN >=", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManLessThan(String value) {
            addCriterion("PAYER_MAN <", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManLessThanOrEqualTo(String value) {
            addCriterion("PAYER_MAN <=", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManLike(String value) {
            addCriterion("PAYER_MAN like", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManNotLike(String value) {
            addCriterion("PAYER_MAN not like", value, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManIn(List<String> values) {
            addCriterion("PAYER_MAN in", values, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManNotIn(List<String> values) {
            addCriterion("PAYER_MAN not in", values, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManBetween(String value1, String value2) {
            addCriterion("PAYER_MAN between", value1, value2, "payerMan");
            return (Criteria) this;
        }

        public Criteria andPayerManNotBetween(String value1, String value2) {
            addCriterion("PAYER_MAN not between", value1, value2, "payerMan");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("PAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("PAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterionForJDBCDate("PAY_DATE =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PAY_DATE <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PAY_DATE >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PAY_DATE >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterionForJDBCDate("PAY_DATE <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PAY_DATE <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterionForJDBCDate("PAY_DATE in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PAY_DATE not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PAY_DATE between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PAY_DATE not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayeeManLikeInsensitive(String value) {
            addCriterion("upper(PAYEE_MAN) like", value.toUpperCase(), "payeeMan");
            return (Criteria) this;
        }

        public Criteria andPayerManLikeInsensitive(String value) {
            addCriterion("upper(PAYER_MAN) like", value.toUpperCase(), "payerMan");
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