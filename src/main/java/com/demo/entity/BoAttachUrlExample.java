package com.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class BoAttachUrlExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public BoAttachUrlExample() {
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
        
        public Criteria andidIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        public Criteria andidIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria andidEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andidNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andidNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andAttachUrlIsNull() {
            addCriterion("attach_url is null");
            return (Criteria) this;
        }
        public Criteria andAttachUrlIsNotNull() {
            addCriterion("attach_url is not null");
            return (Criteria) this;
        }
        public Criteria andAttachUrlEqualTo(String value) {
            addCriterion("attach_url =", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotEqualTo(String value) {
            addCriterion("attach_url <>", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThan(String value) {
            addCriterion("attach_url >", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThanOrEqualTo(String value) {
            addCriterion("attach_url >=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThan(String value) {
            addCriterion("attach_url <", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThanOrEqualTo(String value) {
            addCriterion("attach_url <=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIn(List<String> values) {
            addCriterion("attach_url in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotIn(List<String> values) {
            addCriterion("attach_url not in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlBetween(String value1, String value2) {
            addCriterion("attach_url between", value1, value2, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotBetween(String value1, String value2) {
            addCriterion("attach_url not between", value1, value2, "attachUrl");
            return (Criteria) this;
        }
        public Criteria andAttachStatusIsNull() {
            addCriterion("attach_status is null");
            return (Criteria) this;
        }
        public Criteria andAttachStatusIsNotNull() {
            addCriterion("attach_status is not null");
            return (Criteria) this;
        }
        public Criteria andAttachStatusEqualTo(String value) {
            addCriterion("attach_status =", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusNotEqualTo(String value) {
            addCriterion("attach_status <>", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusGreaterThan(String value) {
            addCriterion("attach_status >", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusGreaterThanOrEqualTo(String value) {
            addCriterion("attach_status >=", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusLessThan(String value) {
            addCriterion("attach_status <", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusLessThanOrEqualTo(String value) {
            addCriterion("attach_status <=", value, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusIn(List<String> values) {
            addCriterion("attach_status in", values, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusNotIn(List<String> values) {
            addCriterion("attach_status not in", values, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusBetween(String value1, String value2) {
            addCriterion("attach_status between", value1, value2, "attachStatus");
            return (Criteria) this;
        }

        public Criteria andAttachStatusNotBetween(String value1, String value2) {
            addCriterion("attach_status not between", value1, value2, "attachStatus");
            return (Criteria) this;
        }
        public Criteria andAttachEmailIsNull() {
            addCriterion("attach_email is null");
            return (Criteria) this;
        }
        public Criteria andAttachEmailIsNotNull() {
            addCriterion("attach_email is not null");
            return (Criteria) this;
        }
        public Criteria andAttachEmailEqualTo(String value) {
            addCriterion("attach_email =", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailNotEqualTo(String value) {
            addCriterion("attach_email <>", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailGreaterThan(String value) {
            addCriterion("attach_email >", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailGreaterThanOrEqualTo(String value) {
            addCriterion("attach_email >=", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailLessThan(String value) {
            addCriterion("attach_email <", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailLessThanOrEqualTo(String value) {
            addCriterion("attach_email <=", value, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailIn(List<String> values) {
            addCriterion("attach_email in", values, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailNotIn(List<String> values) {
            addCriterion("attach_email not in", values, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailBetween(String value1, String value2) {
            addCriterion("attach_email between", value1, value2, "attachEmail");
            return (Criteria) this;
        }

        public Criteria andAttachEmailNotBetween(String value1, String value2) {
            addCriterion("attach_email not between", value1, value2, "attachEmail");
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