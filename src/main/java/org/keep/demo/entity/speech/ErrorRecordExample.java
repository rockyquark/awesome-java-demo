package org.keep.demo.entity.speech;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrorRecordExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andSfFileIdIsNull() {
            addCriterion("sf_file_id is null");
            return (Criteria) this;
        }

        public Criteria andSfFileIdIsNotNull() {
            addCriterion("sf_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andSfFileIdEqualTo(Integer value) {
            addCriterion("sf_file_id =", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdNotEqualTo(Integer value) {
            addCriterion("sf_file_id <>", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdGreaterThan(Integer value) {
            addCriterion("sf_file_id >", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sf_file_id >=", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdLessThan(Integer value) {
            addCriterion("sf_file_id <", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("sf_file_id <=", value, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdIn(List<Integer> values) {
            addCriterion("sf_file_id in", values, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdNotIn(List<Integer> values) {
            addCriterion("sf_file_id not in", values, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdBetween(Integer value1, Integer value2) {
            addCriterion("sf_file_id between", value1, value2, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSfFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sf_file_id not between", value1, value2, "sfFileId");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrIsNull() {
            addCriterion("sofl_seq_nr is null");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrIsNotNull() {
            addCriterion("sofl_seq_nr is not null");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrEqualTo(String value) {
            addCriterion("sofl_seq_nr =", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrNotEqualTo(String value) {
            addCriterion("sofl_seq_nr <>", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrGreaterThan(String value) {
            addCriterion("sofl_seq_nr >", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrGreaterThanOrEqualTo(String value) {
            addCriterion("sofl_seq_nr >=", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrLessThan(String value) {
            addCriterion("sofl_seq_nr <", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrLessThanOrEqualTo(String value) {
            addCriterion("sofl_seq_nr <=", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrLike(String value) {
            addCriterion("sofl_seq_nr like", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrNotLike(String value) {
            addCriterion("sofl_seq_nr not like", value, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrIn(List<String> values) {
            addCriterion("sofl_seq_nr in", values, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrNotIn(List<String> values) {
            addCriterion("sofl_seq_nr not in", values, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrBetween(String value1, String value2) {
            addCriterion("sofl_seq_nr between", value1, value2, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andSoflSeqNrNotBetween(String value1, String value2) {
            addCriterion("sofl_seq_nr not between", value1, value2, "soflSeqNr");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIsNull() {
            addCriterion("error_location is null");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIsNotNull() {
            addCriterion("error_location is not null");
            return (Criteria) this;
        }

        public Criteria andErrorLocationEqualTo(String value) {
            addCriterion("error_location =", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotEqualTo(String value) {
            addCriterion("error_location <>", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationGreaterThan(String value) {
            addCriterion("error_location >", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationGreaterThanOrEqualTo(String value) {
            addCriterion("error_location >=", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLessThan(String value) {
            addCriterion("error_location <", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLessThanOrEqualTo(String value) {
            addCriterion("error_location <=", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLike(String value) {
            addCriterion("error_location like", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotLike(String value) {
            addCriterion("error_location not like", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIn(List<String> values) {
            addCriterion("error_location in", values, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotIn(List<String> values) {
            addCriterion("error_location not in", values, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationBetween(String value1, String value2) {
            addCriterion("error_location between", value1, value2, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotBetween(String value1, String value2) {
            addCriterion("error_location not between", value1, value2, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNull() {
            addCriterion("error_code is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("error_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(Integer value) {
            addCriterion("error_code =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(Integer value) {
            addCriterion("error_code <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(Integer value) {
            addCriterion("error_code >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_code >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(Integer value) {
            addCriterion("error_code <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(Integer value) {
            addCriterion("error_code <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<Integer> values) {
            addCriterion("error_code in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<Integer> values) {
            addCriterion("error_code not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(Integer value1, Integer value2) {
            addCriterion("error_code between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("error_code not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryIsNull() {
            addCriterion("error_summary is null");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryIsNotNull() {
            addCriterion("error_summary is not null");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryEqualTo(String value) {
            addCriterion("error_summary =", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryNotEqualTo(String value) {
            addCriterion("error_summary <>", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryGreaterThan(String value) {
            addCriterion("error_summary >", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("error_summary >=", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryLessThan(String value) {
            addCriterion("error_summary <", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryLessThanOrEqualTo(String value) {
            addCriterion("error_summary <=", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryLike(String value) {
            addCriterion("error_summary like", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryNotLike(String value) {
            addCriterion("error_summary not like", value, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryIn(List<String> values) {
            addCriterion("error_summary in", values, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryNotIn(List<String> values) {
            addCriterion("error_summary not in", values, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryBetween(String value1, String value2) {
            addCriterion("error_summary between", value1, value2, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andErrorSummaryNotBetween(String value1, String value2) {
            addCriterion("error_summary not between", value1, value2, "errorSummary");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
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