package com.demo.entity.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class OrderTicketsExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OrderTicketsExample() {
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

        public Criteria andOrderticketsIdIsNull() {
            addCriterion("ordertickets_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdIsNotNull() {
            addCriterion("ordertickets_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdEqualTo(Integer value) {
            addCriterion("ordertickets_id =", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdNotEqualTo(Integer value) {
            addCriterion("ordertickets_id <>", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdGreaterThan(Integer value) {
            addCriterion("ordertickets_id >", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordertickets_id >=", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdLessThan(Integer value) {
            addCriterion("ordertickets_id <", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ordertickets_id <=", value, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdIn(List<Integer> values) {
            addCriterion("ordertickets_id in", values, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdNotIn(List<Integer> values) {
            addCriterion("ordertickets_id not in", values, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdBetween(Integer value1, Integer value2) {
            addCriterion("ordertickets_id between", value1, value2, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderticketsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ordertickets_id not between", value1, value2, "orderticketsId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIsNull() {
            addCriterion("order_user is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIsNotNull() {
            addCriterion("order_user is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserEqualTo(String value) {
            addCriterion("order_user =", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotEqualTo(String value) {
            addCriterion("order_user <>", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserGreaterThan(String value) {
            addCriterion("order_user >", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserGreaterThanOrEqualTo(String value) {
            addCriterion("order_user >=", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLessThan(String value) {
            addCriterion("order_user <", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLessThanOrEqualTo(String value) {
            addCriterion("order_user <=", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLike(String value) {
            addCriterion("order_user like", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotLike(String value) {
            addCriterion("order_user not like", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserIn(List<String> values) {
            addCriterion("order_user in", values, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotIn(List<String> values) {
            addCriterion("order_user not in", values, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserBetween(String value1, String value2) {
            addCriterion("order_user between", value1, value2, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotBetween(String value1, String value2) {
            addCriterion("order_user not between", value1, value2, "orderUser");
            return (Criteria) this;
        }

        public Criteria andFromStationIsNull() {
            addCriterion("from_station is null");
            return (Criteria) this;
        }

        public Criteria andFromStationIsNotNull() {
            addCriterion("from_station is not null");
            return (Criteria) this;
        }

        public Criteria andFromStationEqualTo(String value) {
            addCriterion("from_station =", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationNotEqualTo(String value) {
            addCriterion("from_station <>", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationGreaterThan(String value) {
            addCriterion("from_station >", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationGreaterThanOrEqualTo(String value) {
            addCriterion("from_station >=", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationLessThan(String value) {
            addCriterion("from_station <", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationLessThanOrEqualTo(String value) {
            addCriterion("from_station <=", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationLike(String value) {
            addCriterion("from_station like", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationNotLike(String value) {
            addCriterion("from_station not like", value, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationIn(List<String> values) {
            addCriterion("from_station in", values, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationNotIn(List<String> values) {
            addCriterion("from_station not in", values, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationBetween(String value1, String value2) {
            addCriterion("from_station between", value1, value2, "fromStation");
            return (Criteria) this;
        }

        public Criteria andFromStationNotBetween(String value1, String value2) {
            addCriterion("from_station not between", value1, value2, "fromStation");
            return (Criteria) this;
        }

        public Criteria andToStationIsNull() {
            addCriterion("to_station is null");
            return (Criteria) this;
        }

        public Criteria andToStationIsNotNull() {
            addCriterion("to_station is not null");
            return (Criteria) this;
        }

        public Criteria andToStationEqualTo(String value) {
            addCriterion("to_station =", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationNotEqualTo(String value) {
            addCriterion("to_station <>", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationGreaterThan(String value) {
            addCriterion("to_station >", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationGreaterThanOrEqualTo(String value) {
            addCriterion("to_station >=", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationLessThan(String value) {
            addCriterion("to_station <", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationLessThanOrEqualTo(String value) {
            addCriterion("to_station <=", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationLike(String value) {
            addCriterion("to_station like", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationNotLike(String value) {
            addCriterion("to_station not like", value, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationIn(List<String> values) {
            addCriterion("to_station in", values, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationNotIn(List<String> values) {
            addCriterion("to_station not in", values, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationBetween(String value1, String value2) {
            addCriterion("to_station between", value1, value2, "toStation");
            return (Criteria) this;
        }

        public Criteria andToStationNotBetween(String value1, String value2) {
            addCriterion("to_station not between", value1, value2, "toStation");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(Date value) {
            addCriterion("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(Date value) {
            addCriterion("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(Date value) {
            addCriterion("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(Date value) {
            addCriterion("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(Date value) {
            addCriterion("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<Date> values) {
            addCriterion("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<Date> values) {
            addCriterion("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(Date value1, Date value2) {
            addCriterion("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(Date value1, Date value2) {
            addCriterion("order_date not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNull() {
            addCriterion("email_address is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNotNull() {
            addCriterion("email_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressEqualTo(String value) {
            addCriterion("email_address =", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotEqualTo(String value) {
            addCriterion("email_address <>", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThan(String value) {
            addCriterion("email_address >", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("email_address >=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThan(String value) {
            addCriterion("email_address <", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("email_address <=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLike(String value) {
            addCriterion("email_address like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotLike(String value) {
            addCriterion("email_address not like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIn(List<String> values) {
            addCriterion("email_address in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotIn(List<String> values) {
            addCriterion("email_address not in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressBetween(String value1, String value2) {
            addCriterion("email_address between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotBetween(String value1, String value2) {
            addCriterion("email_address not between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserLikeInsensitive(String value) {
            addCriterion("upper(order_user) like", value.toUpperCase(), "orderUser");
            return (Criteria) this;
        }

        public Criteria andFromStationLikeInsensitive(String value) {
            addCriterion("upper(from_station) like", value.toUpperCase(), "fromStation");
            return (Criteria) this;
        }

        public Criteria andToStationLikeInsensitive(String value) {
            addCriterion("upper(to_station) like", value.toUpperCase(), "toStation");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLikeInsensitive(String value) {
            addCriterion("upper(email_address) like", value.toUpperCase(), "emailAddress");
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