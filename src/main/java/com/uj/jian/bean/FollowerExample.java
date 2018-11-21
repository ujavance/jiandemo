package com.uj.jian.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowerExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andFollowidIsNull() {
            addCriterion("followId is null");
            return (Criteria) this;
        }

        public Criteria andFollowidIsNotNull() {
            addCriterion("followId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowidEqualTo(Integer value) {
            addCriterion("followId =", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotEqualTo(Integer value) {
            addCriterion("followId <>", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThan(Integer value) {
            addCriterion("followId >", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("followId >=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThan(Integer value) {
            addCriterion("followId <", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("followId <=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidIn(List<Integer> values) {
            addCriterion("followId in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotIn(List<Integer> values) {
            addCriterion("followId not in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidBetween(Integer value1, Integer value2) {
            addCriterion("followId between", value1, value2, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("followId not between", value1, value2, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowtimeIsNull() {
            addCriterion("followTime is null");
            return (Criteria) this;
        }

        public Criteria andFollowtimeIsNotNull() {
            addCriterion("followTime is not null");
            return (Criteria) this;
        }

        public Criteria andFollowtimeEqualTo(Date value) {
            addCriterion("followTime =", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeNotEqualTo(Date value) {
            addCriterion("followTime <>", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeGreaterThan(Date value) {
            addCriterion("followTime >", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("followTime >=", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeLessThan(Date value) {
            addCriterion("followTime <", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeLessThanOrEqualTo(Date value) {
            addCriterion("followTime <=", value, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeIn(List<Date> values) {
            addCriterion("followTime in", values, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeNotIn(List<Date> values) {
            addCriterion("followTime not in", values, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeBetween(Date value1, Date value2) {
            addCriterion("followTime between", value1, value2, "followtime");
            return (Criteria) this;
        }

        public Criteria andFollowtimeNotBetween(Date value1, Date value2) {
            addCriterion("followTime not between", value1, value2, "followtime");
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