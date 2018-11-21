package com.uj.jian.bean;

import java.util.ArrayList;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
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

        public Criteria andArticleidIsNull() {
            addCriterion("articleId is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("articleId is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(Integer value) {
            addCriterion("articleId =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(Integer value) {
            addCriterion("articleId <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(Integer value) {
            addCriterion("articleId >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("articleId >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(Integer value) {
            addCriterion("articleId <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(Integer value) {
            addCriterion("articleId <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<Integer> values) {
            addCriterion("articleId in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<Integer> values) {
            addCriterion("articleId not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(Integer value1, Integer value2) {
            addCriterion("articleId between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(Integer value1, Integer value2) {
            addCriterion("articleId not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andIslikeIsNull() {
            addCriterion("isLike is null");
            return (Criteria) this;
        }

        public Criteria andIslikeIsNotNull() {
            addCriterion("isLike is not null");
            return (Criteria) this;
        }

        public Criteria andIslikeEqualTo(Byte value) {
            addCriterion("isLike =", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotEqualTo(Byte value) {
            addCriterion("isLike <>", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeGreaterThan(Byte value) {
            addCriterion("isLike >", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeGreaterThanOrEqualTo(Byte value) {
            addCriterion("isLike >=", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeLessThan(Byte value) {
            addCriterion("isLike <", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeLessThanOrEqualTo(Byte value) {
            addCriterion("isLike <=", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeIn(List<Byte> values) {
            addCriterion("isLike in", values, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotIn(List<Byte> values) {
            addCriterion("isLike not in", values, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeBetween(Byte value1, Byte value2) {
            addCriterion("isLike between", value1, value2, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotBetween(Byte value1, Byte value2) {
            addCriterion("isLike not between", value1, value2, "islike");
            return (Criteria) this;
        }

        public Criteria andIscolloectIsNull() {
            addCriterion("isColloect is null");
            return (Criteria) this;
        }

        public Criteria andIscolloectIsNotNull() {
            addCriterion("isColloect is not null");
            return (Criteria) this;
        }

        public Criteria andIscolloectEqualTo(Byte value) {
            addCriterion("isColloect =", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectNotEqualTo(Byte value) {
            addCriterion("isColloect <>", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectGreaterThan(Byte value) {
            addCriterion("isColloect >", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectGreaterThanOrEqualTo(Byte value) {
            addCriterion("isColloect >=", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectLessThan(Byte value) {
            addCriterion("isColloect <", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectLessThanOrEqualTo(Byte value) {
            addCriterion("isColloect <=", value, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectIn(List<Byte> values) {
            addCriterion("isColloect in", values, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectNotIn(List<Byte> values) {
            addCriterion("isColloect not in", values, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectBetween(Byte value1, Byte value2) {
            addCriterion("isColloect between", value1, value2, "iscolloect");
            return (Criteria) this;
        }

        public Criteria andIscolloectNotBetween(Byte value1, Byte value2) {
            addCriterion("isColloect not between", value1, value2, "iscolloect");
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