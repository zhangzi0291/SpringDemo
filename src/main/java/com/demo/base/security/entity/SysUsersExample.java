package com.demo.base.security.entity;

import java.util.ArrayList;
import java.util.List;

import com.demo.base.Example;
import com.demo.base.Page;

public class SysUsersExample implements Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public SysUsersExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserDescIsNull() {
            addCriterion("user_desc is null");
            return (Criteria) this;
        }

        public Criteria andUserDescIsNotNull() {
            addCriterion("user_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescEqualTo(String value) {
            addCriterion("user_desc =", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotEqualTo(String value) {
            addCriterion("user_desc <>", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThan(String value) {
            addCriterion("user_desc >", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThanOrEqualTo(String value) {
            addCriterion("user_desc >=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThan(String value) {
            addCriterion("user_desc <", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThanOrEqualTo(String value) {
            addCriterion("user_desc <=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLike(String value) {
            addCriterion("user_desc like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotLike(String value) {
            addCriterion("user_desc not like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescIn(List<String> values) {
            addCriterion("user_desc in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotIn(List<String> values) {
            addCriterion("user_desc not in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescBetween(String value1, String value2) {
            addCriterion("user_desc between", value1, value2, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotBetween(String value1, String value2) {
            addCriterion("user_desc not between", value1, value2, "userDesc");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andUserDeptIsNull() {
            addCriterion("user_dept is null");
            return (Criteria) this;
        }

        public Criteria andUserDeptIsNotNull() {
            addCriterion("user_dept is not null");
            return (Criteria) this;
        }

        public Criteria andUserDeptEqualTo(String value) {
            addCriterion("user_dept =", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotEqualTo(String value) {
            addCriterion("user_dept <>", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptGreaterThan(String value) {
            addCriterion("user_dept >", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptGreaterThanOrEqualTo(String value) {
            addCriterion("user_dept >=", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptLessThan(String value) {
            addCriterion("user_dept <", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptLessThanOrEqualTo(String value) {
            addCriterion("user_dept <=", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptLike(String value) {
            addCriterion("user_dept like", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotLike(String value) {
            addCriterion("user_dept not like", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptIn(List<String> values) {
            addCriterion("user_dept in", values, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotIn(List<String> values) {
            addCriterion("user_dept not in", values, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptBetween(String value1, String value2) {
            addCriterion("user_dept between", value1, value2, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotBetween(String value1, String value2) {
            addCriterion("user_dept not between", value1, value2, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDutyIsNull() {
            addCriterion("user_duty is null");
            return (Criteria) this;
        }

        public Criteria andUserDutyIsNotNull() {
            addCriterion("user_duty is not null");
            return (Criteria) this;
        }

        public Criteria andUserDutyEqualTo(String value) {
            addCriterion("user_duty =", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyNotEqualTo(String value) {
            addCriterion("user_duty <>", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyGreaterThan(String value) {
            addCriterion("user_duty >", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyGreaterThanOrEqualTo(String value) {
            addCriterion("user_duty >=", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyLessThan(String value) {
            addCriterion("user_duty <", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyLessThanOrEqualTo(String value) {
            addCriterion("user_duty <=", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyLike(String value) {
            addCriterion("user_duty like", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyNotLike(String value) {
            addCriterion("user_duty not like", value, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyIn(List<String> values) {
            addCriterion("user_duty in", values, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyNotIn(List<String> values) {
            addCriterion("user_duty not in", values, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyBetween(String value1, String value2) {
            addCriterion("user_duty between", value1, value2, "userDuty");
            return (Criteria) this;
        }

        public Criteria andUserDutyNotBetween(String value1, String value2) {
            addCriterion("user_duty not between", value1, value2, "userDuty");
            return (Criteria) this;
        }

        public Criteria andSubSystemIsNull() {
            addCriterion("sub_system is null");
            return (Criteria) this;
        }

        public Criteria andSubSystemIsNotNull() {
            addCriterion("sub_system is not null");
            return (Criteria) this;
        }

        public Criteria andSubSystemEqualTo(String value) {
            addCriterion("sub_system =", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotEqualTo(String value) {
            addCriterion("sub_system <>", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemGreaterThan(String value) {
            addCriterion("sub_system >", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemGreaterThanOrEqualTo(String value) {
            addCriterion("sub_system >=", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLessThan(String value) {
            addCriterion("sub_system <", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLessThanOrEqualTo(String value) {
            addCriterion("sub_system <=", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLike(String value) {
            addCriterion("sub_system like", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotLike(String value) {
            addCriterion("sub_system not like", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemIn(List<String> values) {
            addCriterion("sub_system in", values, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotIn(List<String> values) {
            addCriterion("sub_system not in", values, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemBetween(String value1, String value2) {
            addCriterion("sub_system between", value1, value2, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotBetween(String value1, String value2) {
            addCriterion("sub_system not between", value1, value2, "subSystem");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNull() {
            addCriterion("user_img is null");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNotNull() {
            addCriterion("user_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserImgEqualTo(String value) {
            addCriterion("user_img =", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotEqualTo(String value) {
            addCriterion("user_img <>", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThan(String value) {
            addCriterion("user_img >", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_img >=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThan(String value) {
            addCriterion("user_img <", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThanOrEqualTo(String value) {
            addCriterion("user_img <=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLike(String value) {
            addCriterion("user_img like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotLike(String value) {
            addCriterion("user_img not like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgIn(List<String> values) {
            addCriterion("user_img in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotIn(List<String> values) {
            addCriterion("user_img not in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgBetween(String value1, String value2) {
            addCriterion("user_img between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotBetween(String value1, String value2) {
            addCriterion("user_img not between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andUserAccountLikeInsensitive(String value) {
            addCriterion("upper(user_account) like", value.toUpperCase(), "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLikeInsensitive(String value) {
            addCriterion("upper(user_password) like", value.toUpperCase(), "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserDescLikeInsensitive(String value) {
            addCriterion("upper(user_desc) like", value.toUpperCase(), "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDeptLikeInsensitive(String value) {
            addCriterion("upper(user_dept) like", value.toUpperCase(), "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDutyLikeInsensitive(String value) {
            addCriterion("upper(user_duty) like", value.toUpperCase(), "userDuty");
            return (Criteria) this;
        }

        public Criteria andSubSystemLikeInsensitive(String value) {
            addCriterion("upper(sub_system) like", value.toUpperCase(), "subSystem");
            return (Criteria) this;
        }

        public Criteria andUserImgLikeInsensitive(String value) {
            addCriterion("upper(user_img) like", value.toUpperCase(), "userImg");
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