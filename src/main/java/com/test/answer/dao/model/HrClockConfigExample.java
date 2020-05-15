package com.test.answer.dao.model;

import java.util.ArrayList;
import java.util.List;

public class HrClockConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HrClockConfigExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClockInTimeIsNull() {
            addCriterion("clock_in_time is null");
            return (Criteria) this;
        }

        public Criteria andClockInTimeIsNotNull() {
            addCriterion("clock_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andClockInTimeEqualTo(String value) {
            addCriterion("clock_in_time =", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeNotEqualTo(String value) {
            addCriterion("clock_in_time <>", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeGreaterThan(String value) {
            addCriterion("clock_in_time >", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("clock_in_time >=", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeLessThan(String value) {
            addCriterion("clock_in_time <", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeLessThanOrEqualTo(String value) {
            addCriterion("clock_in_time <=", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeLike(String value) {
            addCriterion("clock_in_time like", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeNotLike(String value) {
            addCriterion("clock_in_time not like", value, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeIn(List<String> values) {
            addCriterion("clock_in_time in", values, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeNotIn(List<String> values) {
            addCriterion("clock_in_time not in", values, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeBetween(String value1, String value2) {
            addCriterion("clock_in_time between", value1, value2, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeNotBetween(String value1, String value2) {
            addCriterion("clock_in_time not between", value1, value2, "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeIsNull() {
            addCriterion("clock_out_time is null");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeIsNotNull() {
            addCriterion("clock_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeEqualTo(String value) {
            addCriterion("clock_out_time =", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeNotEqualTo(String value) {
            addCriterion("clock_out_time <>", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeGreaterThan(String value) {
            addCriterion("clock_out_time >", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("clock_out_time >=", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeLessThan(String value) {
            addCriterion("clock_out_time <", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeLessThanOrEqualTo(String value) {
            addCriterion("clock_out_time <=", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeLike(String value) {
            addCriterion("clock_out_time like", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeNotLike(String value) {
            addCriterion("clock_out_time not like", value, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeIn(List<String> values) {
            addCriterion("clock_out_time in", values, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeNotIn(List<String> values) {
            addCriterion("clock_out_time not in", values, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeBetween(String value1, String value2) {
            addCriterion("clock_out_time between", value1, value2, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeNotBetween(String value1, String value2) {
            addCriterion("clock_out_time not between", value1, value2, "clockOutTime");
            return (Criteria) this;
        }

        public Criteria andClockInTimeLikeInsensitive(String value) {
            addCriterion("upper(clock_in_time) like", value.toUpperCase(), "clockInTime");
            return (Criteria) this;
        }

        public Criteria andClockOutTimeLikeInsensitive(String value) {
            addCriterion("upper(clock_out_time) like", value.toUpperCase(), "clockOutTime");
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