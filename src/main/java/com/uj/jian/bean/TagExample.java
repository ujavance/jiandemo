package com.uj.jian.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TagExample() {
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

        public Criteria andTagidIsNull() {
            addCriterion("tagId is null");
            return (Criteria) this;
        }

        public Criteria andTagidIsNotNull() {
            addCriterion("tagId is not null");
            return (Criteria) this;
        }

        public Criteria andTagidEqualTo(Integer value) {
            addCriterion("tagId =", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotEqualTo(Integer value) {
            addCriterion("tagId <>", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidGreaterThan(Integer value) {
            addCriterion("tagId >", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tagId >=", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidLessThan(Integer value) {
            addCriterion("tagId <", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidLessThanOrEqualTo(Integer value) {
            addCriterion("tagId <=", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidIn(List<Integer> values) {
            addCriterion("tagId in", values, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotIn(List<Integer> values) {
            addCriterion("tagId not in", values, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidBetween(Integer value1, Integer value2) {
            addCriterion("tagId between", value1, value2, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotBetween(Integer value1, Integer value2) {
            addCriterion("tagId not between", value1, value2, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNull() {
            addCriterion("tagName is null");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNotNull() {
            addCriterion("tagName is not null");
            return (Criteria) this;
        }

        public Criteria andTagnameEqualTo(String value) {
            addCriterion("tagName =", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotEqualTo(String value) {
            addCriterion("tagName <>", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThan(String value) {
            addCriterion("tagName >", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThanOrEqualTo(String value) {
            addCriterion("tagName >=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThan(String value) {
            addCriterion("tagName <", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThanOrEqualTo(String value) {
            addCriterion("tagName <=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLike(String value) {
            addCriterion("tagName like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotLike(String value) {
            addCriterion("tagName not like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameIn(List<String> values) {
            addCriterion("tagName in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotIn(List<String> values) {
            addCriterion("tagName not in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameBetween(String value1, String value2) {
            addCriterion("tagName between", value1, value2, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotBetween(String value1, String value2) {
            addCriterion("tagName not between", value1, value2, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeIsNull() {
            addCriterion("tagCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeIsNotNull() {
            addCriterion("tagCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeEqualTo(Date value) {
            addCriterion("tagCreateTime =", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeNotEqualTo(Date value) {
            addCriterion("tagCreateTime <>", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeGreaterThan(Date value) {
            addCriterion("tagCreateTime >", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tagCreateTime >=", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeLessThan(Date value) {
            addCriterion("tagCreateTime <", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("tagCreateTime <=", value, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeIn(List<Date> values) {
            addCriterion("tagCreateTime in", values, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeNotIn(List<Date> values) {
            addCriterion("tagCreateTime not in", values, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeBetween(Date value1, Date value2) {
            addCriterion("tagCreateTime between", value1, value2, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("tagCreateTime not between", value1, value2, "tagcreatetime");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersIsNull() {
            addCriterion("tagArticleNumbers is null");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersIsNotNull() {
            addCriterion("tagArticleNumbers is not null");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersEqualTo(Integer value) {
            addCriterion("tagArticleNumbers =", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersNotEqualTo(Integer value) {
            addCriterion("tagArticleNumbers <>", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersGreaterThan(Integer value) {
            addCriterion("tagArticleNumbers >", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersGreaterThanOrEqualTo(Integer value) {
            addCriterion("tagArticleNumbers >=", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersLessThan(Integer value) {
            addCriterion("tagArticleNumbers <", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersLessThanOrEqualTo(Integer value) {
            addCriterion("tagArticleNumbers <=", value, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersIn(List<Integer> values) {
            addCriterion("tagArticleNumbers in", values, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersNotIn(List<Integer> values) {
            addCriterion("tagArticleNumbers not in", values, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersBetween(Integer value1, Integer value2) {
            addCriterion("tagArticleNumbers between", value1, value2, "tagarticlenumbers");
            return (Criteria) this;
        }

        public Criteria andTagarticlenumbersNotBetween(Integer value1, Integer value2) {
            addCriterion("tagArticleNumbers not between", value1, value2, "tagarticlenumbers");
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