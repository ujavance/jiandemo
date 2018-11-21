package com.uj.jian.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleheadIsNull() {
            addCriterion("articleHead is null");
            return (Criteria) this;
        }

        public Criteria andArticleheadIsNotNull() {
            addCriterion("articleHead is not null");
            return (Criteria) this;
        }

        public Criteria andArticleheadEqualTo(String value) {
            addCriterion("articleHead =", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadNotEqualTo(String value) {
            addCriterion("articleHead <>", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadGreaterThan(String value) {
            addCriterion("articleHead >", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadGreaterThanOrEqualTo(String value) {
            addCriterion("articleHead >=", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadLessThan(String value) {
            addCriterion("articleHead <", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadLessThanOrEqualTo(String value) {
            addCriterion("articleHead <=", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadLike(String value) {
            addCriterion("articleHead like", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadNotLike(String value) {
            addCriterion("articleHead not like", value, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadIn(List<String> values) {
            addCriterion("articleHead in", values, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadNotIn(List<String> values) {
            addCriterion("articleHead not in", values, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadBetween(String value1, String value2) {
            addCriterion("articleHead between", value1, value2, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticleheadNotBetween(String value1, String value2) {
            addCriterion("articleHead not between", value1, value2, "articlehead");
            return (Criteria) this;
        }

        public Criteria andArticletimeIsNull() {
            addCriterion("articleTime is null");
            return (Criteria) this;
        }

        public Criteria andArticletimeIsNotNull() {
            addCriterion("articleTime is not null");
            return (Criteria) this;
        }

        public Criteria andArticletimeEqualTo(Date value) {
            addCriterion("articleTime =", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeNotEqualTo(Date value) {
            addCriterion("articleTime <>", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeGreaterThan(Date value) {
            addCriterion("articleTime >", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeGreaterThanOrEqualTo(Date value) {
            addCriterion("articleTime >=", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeLessThan(Date value) {
            addCriterion("articleTime <", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeLessThanOrEqualTo(Date value) {
            addCriterion("articleTime <=", value, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeIn(List<Date> values) {
            addCriterion("articleTime in", values, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeNotIn(List<Date> values) {
            addCriterion("articleTime not in", values, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeBetween(Date value1, Date value2) {
            addCriterion("articleTime between", value1, value2, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticletimeNotBetween(Date value1, Date value2) {
            addCriterion("articleTime not between", value1, value2, "articletime");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsIsNull() {
            addCriterion("articleReadNums is null");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsIsNotNull() {
            addCriterion("articleReadNums is not null");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsEqualTo(Integer value) {
            addCriterion("articleReadNums =", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsNotEqualTo(Integer value) {
            addCriterion("articleReadNums <>", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsGreaterThan(Integer value) {
            addCriterion("articleReadNums >", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("articleReadNums >=", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsLessThan(Integer value) {
            addCriterion("articleReadNums <", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsLessThanOrEqualTo(Integer value) {
            addCriterion("articleReadNums <=", value, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsIn(List<Integer> values) {
            addCriterion("articleReadNums in", values, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsNotIn(List<Integer> values) {
            addCriterion("articleReadNums not in", values, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsBetween(Integer value1, Integer value2) {
            addCriterion("articleReadNums between", value1, value2, "articlereadnums");
            return (Criteria) this;
        }

        public Criteria andArticlereadnumsNotBetween(Integer value1, Integer value2) {
            addCriterion("articleReadNums not between", value1, value2, "articlereadnums");
            return (Criteria) this;
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

        public Criteria andUseridInWithUser(List<Integer> values) {
            addCriterion("a.userId in", values, "userid");
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

        public Criteria andLikenumIsNull() {
            addCriterion("likenum is null");
            return (Criteria) this;
        }

        public Criteria andLikenumIsNotNull() {
            addCriterion("likenum is not null");
            return (Criteria) this;
        }

        public Criteria andLikenumEqualTo(Integer value) {
            addCriterion("likenum =", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotEqualTo(Integer value) {
            addCriterion("likenum <>", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumGreaterThan(Integer value) {
            addCriterion("likenum >", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("likenum >=", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumLessThan(Integer value) {
            addCriterion("likenum <", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumLessThanOrEqualTo(Integer value) {
            addCriterion("likenum <=", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumIn(List<Integer> values) {
            addCriterion("likenum in", values, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotIn(List<Integer> values) {
            addCriterion("likenum not in", values, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumBetween(Integer value1, Integer value2) {
            addCriterion("likenum between", value1, value2, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotBetween(Integer value1, Integer value2) {
            addCriterion("likenum not between", value1, value2, "likenum");
            return (Criteria) this;
        }

        public Criteria andUserimgIsNull() {
            addCriterion("userImg is null");
            return (Criteria) this;
        }

        public Criteria andUserimgIsNotNull() {
            addCriterion("userImg is not null");
            return (Criteria) this;
        }

        public Criteria andUserimgEqualTo(String value) {
            addCriterion("userImg =", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotEqualTo(String value) {
            addCriterion("userImg <>", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgGreaterThan(String value) {
            addCriterion("userImg >", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgGreaterThanOrEqualTo(String value) {
            addCriterion("userImg >=", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLessThan(String value) {
            addCriterion("userImg <", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLessThanOrEqualTo(String value) {
            addCriterion("userImg <=", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLike(String value) {
            addCriterion("userImg like", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotLike(String value) {
            addCriterion("userImg not like", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgIn(List<String> values) {
            addCriterion("userImg in", values, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotIn(List<String> values) {
            addCriterion("userImg not in", values, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgBetween(String value1, String value2) {
            addCriterion("userImg between", value1, value2, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotBetween(String value1, String value2) {
            addCriterion("userImg not between", value1, value2, "userimg");
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