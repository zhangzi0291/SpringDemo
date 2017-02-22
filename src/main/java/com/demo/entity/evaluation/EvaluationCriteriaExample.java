package com.demo.entity.evaluation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class EvaluationCriteriaExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EvaluationCriteriaExample() {
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

        public Criteria andEvaluatorsManIsNull() {
            addCriterion("EVALUATORS_MAN is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManIsNotNull() {
            addCriterion("EVALUATORS_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManEqualTo(String value) {
            addCriterion("EVALUATORS_MAN =", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManNotEqualTo(String value) {
            addCriterion("EVALUATORS_MAN <>", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManGreaterThan(String value) {
            addCriterion("EVALUATORS_MAN >", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATORS_MAN >=", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManLessThan(String value) {
            addCriterion("EVALUATORS_MAN <", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManLessThanOrEqualTo(String value) {
            addCriterion("EVALUATORS_MAN <=", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManLike(String value) {
            addCriterion("EVALUATORS_MAN like", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManNotLike(String value) {
            addCriterion("EVALUATORS_MAN not like", value, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManIn(List<String> values) {
            addCriterion("EVALUATORS_MAN in", values, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManNotIn(List<String> values) {
            addCriterion("EVALUATORS_MAN not in", values, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManBetween(String value1, String value2) {
            addCriterion("EVALUATORS_MAN between", value1, value2, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManNotBetween(String value1, String value2) {
            addCriterion("EVALUATORS_MAN not between", value1, value2, "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andValuationManIsNull() {
            addCriterion("VALUATION_MAN is null");
            return (Criteria) this;
        }

        public Criteria andValuationManIsNotNull() {
            addCriterion("VALUATION_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andValuationManEqualTo(String value) {
            addCriterion("VALUATION_MAN =", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManNotEqualTo(String value) {
            addCriterion("VALUATION_MAN <>", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManGreaterThan(String value) {
            addCriterion("VALUATION_MAN >", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManGreaterThanOrEqualTo(String value) {
            addCriterion("VALUATION_MAN >=", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManLessThan(String value) {
            addCriterion("VALUATION_MAN <", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManLessThanOrEqualTo(String value) {
            addCriterion("VALUATION_MAN <=", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManLike(String value) {
            addCriterion("VALUATION_MAN like", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManNotLike(String value) {
            addCriterion("VALUATION_MAN not like", value, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManIn(List<String> values) {
            addCriterion("VALUATION_MAN in", values, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManNotIn(List<String> values) {
            addCriterion("VALUATION_MAN not in", values, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManBetween(String value1, String value2) {
            addCriterion("VALUATION_MAN between", value1, value2, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andValuationManNotBetween(String value1, String value2) {
            addCriterion("VALUATION_MAN not between", value1, value2, "valuationMan");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIsNull() {
            addCriterion("EVALUATION_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIsNotNull() {
            addCriterion("EVALUATION_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreEqualTo(BigDecimal value) {
            addCriterion("EVALUATION_SCORE =", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotEqualTo(BigDecimal value) {
            addCriterion("EVALUATION_SCORE <>", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreGreaterThan(BigDecimal value) {
            addCriterion("EVALUATION_SCORE >", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVALUATION_SCORE >=", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreLessThan(BigDecimal value) {
            addCriterion("EVALUATION_SCORE <", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVALUATION_SCORE <=", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIn(List<BigDecimal> values) {
            addCriterion("EVALUATION_SCORE in", values, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotIn(List<BigDecimal> values) {
            addCriterion("EVALUATION_SCORE not in", values, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVALUATION_SCORE between", value1, value2, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVALUATION_SCORE not between", value1, value2, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateIsNull() {
            addCriterion("EVALUATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateIsNotNull() {
            addCriterion("EVALUATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateEqualTo(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE =", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE <>", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE >", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE >=", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateLessThan(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE <", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EVALUATION_DATE <=", value, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateIn(List<Date> values) {
            addCriterionForJDBCDate("EVALUATION_DATE in", values, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EVALUATION_DATE not in", values, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EVALUATION_DATE between", value1, value2, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EVALUATION_DATE not between", value1, value2, "evaluationDate");
            return (Criteria) this;
        }

        public Criteria andEvaluatorsManLikeInsensitive(String value) {
            addCriterion("upper(EVALUATORS_MAN) like", value.toUpperCase(), "evaluatorsMan");
            return (Criteria) this;
        }

        public Criteria andValuationManLikeInsensitive(String value) {
            addCriterion("upper(VALUATION_MAN) like", value.toUpperCase(), "valuationMan");
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