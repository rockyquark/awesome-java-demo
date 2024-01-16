package org.keep.demo.entity.speech;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioTaskScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AudioTaskScheduleExample() {
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

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("check_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("check_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterion("check_start_time =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterion("check_start_time <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterion("check_start_time >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_start_time >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterion("check_start_time <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_start_time <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterion("check_start_time in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterion("check_start_time not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_start_time between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_start_time not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("check_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("check_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("check_end_time =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("check_end_time <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("check_end_time >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_end_time >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("check_end_time <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_end_time <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("check_end_time in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("check_end_time not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_end_time between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_end_time not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeIsNull() {
            addCriterion("check_decrypt_decode_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeIsNotNull() {
            addCriterion("check_decrypt_decode_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeEqualTo(Date value) {
            addCriterion("check_decrypt_decode_start_time =", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeNotEqualTo(Date value) {
            addCriterion("check_decrypt_decode_start_time <>", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeGreaterThan(Date value) {
            addCriterion("check_decrypt_decode_start_time >", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_decrypt_decode_start_time >=", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeLessThan(Date value) {
            addCriterion("check_decrypt_decode_start_time <", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_decrypt_decode_start_time <=", value, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeIn(List<Date> values) {
            addCriterion("check_decrypt_decode_start_time in", values, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeNotIn(List<Date> values) {
            addCriterion("check_decrypt_decode_start_time not in", values, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_decrypt_decode_start_time between", value1, value2, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_decrypt_decode_start_time not between", value1, value2, "checkDecryptDecodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeIsNull() {
            addCriterion("check_decrypt_decode_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeIsNotNull() {
            addCriterion("check_decrypt_decode_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeEqualTo(Date value) {
            addCriterion("check_decrypt_decode_end_time =", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeNotEqualTo(Date value) {
            addCriterion("check_decrypt_decode_end_time <>", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeGreaterThan(Date value) {
            addCriterion("check_decrypt_decode_end_time >", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_decrypt_decode_end_time >=", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeLessThan(Date value) {
            addCriterion("check_decrypt_decode_end_time <", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_decrypt_decode_end_time <=", value, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeIn(List<Date> values) {
            addCriterion("check_decrypt_decode_end_time in", values, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeNotIn(List<Date> values) {
            addCriterion("check_decrypt_decode_end_time not in", values, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_decrypt_decode_end_time between", value1, value2, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckDecryptDecodeEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_decrypt_decode_end_time not between", value1, value2, "checkDecryptDecodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeIsNull() {
            addCriterion("check_transcode_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeIsNotNull() {
            addCriterion("check_transcode_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeEqualTo(Date value) {
            addCriterion("check_transcode_start_time =", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeNotEqualTo(Date value) {
            addCriterion("check_transcode_start_time <>", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeGreaterThan(Date value) {
            addCriterion("check_transcode_start_time >", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_transcode_start_time >=", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeLessThan(Date value) {
            addCriterion("check_transcode_start_time <", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_transcode_start_time <=", value, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeIn(List<Date> values) {
            addCriterion("check_transcode_start_time in", values, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeNotIn(List<Date> values) {
            addCriterion("check_transcode_start_time not in", values, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_transcode_start_time between", value1, value2, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_transcode_start_time not between", value1, value2, "checkTranscodeStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeIsNull() {
            addCriterion("check_transcode_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeIsNotNull() {
            addCriterion("check_transcode_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeEqualTo(Date value) {
            addCriterion("check_transcode_end_time =", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeNotEqualTo(Date value) {
            addCriterion("check_transcode_end_time <>", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeGreaterThan(Date value) {
            addCriterion("check_transcode_end_time >", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_transcode_end_time >=", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeLessThan(Date value) {
            addCriterion("check_transcode_end_time <", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_transcode_end_time <=", value, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeIn(List<Date> values) {
            addCriterion("check_transcode_end_time in", values, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeNotIn(List<Date> values) {
            addCriterion("check_transcode_end_time not in", values, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_transcode_end_time between", value1, value2, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckTranscodeEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_transcode_end_time not between", value1, value2, "checkTranscodeEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeIsNull() {
            addCriterion("check_generate_flac_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeIsNotNull() {
            addCriterion("check_generate_flac_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeEqualTo(Date value) {
            addCriterion("check_generate_flac_start_time =", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeNotEqualTo(Date value) {
            addCriterion("check_generate_flac_start_time <>", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeGreaterThan(Date value) {
            addCriterion("check_generate_flac_start_time >", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_generate_flac_start_time >=", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeLessThan(Date value) {
            addCriterion("check_generate_flac_start_time <", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_generate_flac_start_time <=", value, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeIn(List<Date> values) {
            addCriterion("check_generate_flac_start_time in", values, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeNotIn(List<Date> values) {
            addCriterion("check_generate_flac_start_time not in", values, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_generate_flac_start_time between", value1, value2, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_generate_flac_start_time not between", value1, value2, "checkGenerateFlacStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeIsNull() {
            addCriterion("check_generate_flac_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeIsNotNull() {
            addCriterion("check_generate_flac_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeEqualTo(Date value) {
            addCriterion("check_generate_flac_end_time =", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeNotEqualTo(Date value) {
            addCriterion("check_generate_flac_end_time <>", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeGreaterThan(Date value) {
            addCriterion("check_generate_flac_end_time >", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_generate_flac_end_time >=", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeLessThan(Date value) {
            addCriterion("check_generate_flac_end_time <", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_generate_flac_end_time <=", value, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeIn(List<Date> values) {
            addCriterion("check_generate_flac_end_time in", values, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeNotIn(List<Date> values) {
            addCriterion("check_generate_flac_end_time not in", values, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_generate_flac_end_time between", value1, value2, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckGenerateFlacEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_generate_flac_end_time not between", value1, value2, "checkGenerateFlacEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeIsNull() {
            addCriterion("check_upload_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeIsNotNull() {
            addCriterion("check_upload_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeEqualTo(Date value) {
            addCriterion("check_upload_start_time =", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeNotEqualTo(Date value) {
            addCriterion("check_upload_start_time <>", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeGreaterThan(Date value) {
            addCriterion("check_upload_start_time >", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_upload_start_time >=", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeLessThan(Date value) {
            addCriterion("check_upload_start_time <", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_upload_start_time <=", value, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeIn(List<Date> values) {
            addCriterion("check_upload_start_time in", values, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeNotIn(List<Date> values) {
            addCriterion("check_upload_start_time not in", values, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_upload_start_time between", value1, value2, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_upload_start_time not between", value1, value2, "checkUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeIsNull() {
            addCriterion("check_upload_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeIsNotNull() {
            addCriterion("check_upload_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeEqualTo(Date value) {
            addCriterion("check_upload_end_time =", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeNotEqualTo(Date value) {
            addCriterion("check_upload_end_time <>", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeGreaterThan(Date value) {
            addCriterion("check_upload_end_time >", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_upload_end_time >=", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeLessThan(Date value) {
            addCriterion("check_upload_end_time <", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_upload_end_time <=", value, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeIn(List<Date> values) {
            addCriterion("check_upload_end_time in", values, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeNotIn(List<Date> values) {
            addCriterion("check_upload_end_time not in", values, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_upload_end_time between", value1, value2, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckUploadEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_upload_end_time not between", value1, value2, "checkUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeIsNull() {
            addCriterion("recognise_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeIsNotNull() {
            addCriterion("recognise_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeEqualTo(Date value) {
            addCriterion("recognise_start_time =", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeNotEqualTo(Date value) {
            addCriterion("recognise_start_time <>", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeGreaterThan(Date value) {
            addCriterion("recognise_start_time >", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recognise_start_time >=", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeLessThan(Date value) {
            addCriterion("recognise_start_time <", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("recognise_start_time <=", value, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeIn(List<Date> values) {
            addCriterion("recognise_start_time in", values, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeNotIn(List<Date> values) {
            addCriterion("recognise_start_time not in", values, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeBetween(Date value1, Date value2) {
            addCriterion("recognise_start_time between", value1, value2, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("recognise_start_time not between", value1, value2, "recogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeIsNull() {
            addCriterion("recognise_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeIsNotNull() {
            addCriterion("recognise_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeEqualTo(Date value) {
            addCriterion("recognise_end_time =", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeNotEqualTo(Date value) {
            addCriterion("recognise_end_time <>", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeGreaterThan(Date value) {
            addCriterion("recognise_end_time >", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recognise_end_time >=", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeLessThan(Date value) {
            addCriterion("recognise_end_time <", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("recognise_end_time <=", value, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeIn(List<Date> values) {
            addCriterion("recognise_end_time in", values, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeNotIn(List<Date> values) {
            addCriterion("recognise_end_time not in", values, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeBetween(Date value1, Date value2) {
            addCriterion("recognise_end_time between", value1, value2, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andRecogniseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("recognise_end_time not between", value1, value2, "recogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeIsNull() {
            addCriterion("analysis_storage_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeIsNotNull() {
            addCriterion("analysis_storage_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeEqualTo(Date value) {
            addCriterion("analysis_storage_start_time =", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeNotEqualTo(Date value) {
            addCriterion("analysis_storage_start_time <>", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeGreaterThan(Date value) {
            addCriterion("analysis_storage_start_time >", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_storage_start_time >=", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeLessThan(Date value) {
            addCriterion("analysis_storage_start_time <", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_storage_start_time <=", value, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeIn(List<Date> values) {
            addCriterion("analysis_storage_start_time in", values, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeNotIn(List<Date> values) {
            addCriterion("analysis_storage_start_time not in", values, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_storage_start_time between", value1, value2, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_storage_start_time not between", value1, value2, "analysisStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeIsNull() {
            addCriterion("analysis_storage_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeIsNotNull() {
            addCriterion("analysis_storage_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeEqualTo(Date value) {
            addCriterion("analysis_storage_end_time =", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeNotEqualTo(Date value) {
            addCriterion("analysis_storage_end_time <>", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeGreaterThan(Date value) {
            addCriterion("analysis_storage_end_time >", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_storage_end_time >=", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeLessThan(Date value) {
            addCriterion("analysis_storage_end_time <", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_storage_end_time <=", value, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeIn(List<Date> values) {
            addCriterion("analysis_storage_end_time in", values, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeNotIn(List<Date> values) {
            addCriterion("analysis_storage_end_time not in", values, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_storage_end_time between", value1, value2, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisStorageEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_storage_end_time not between", value1, value2, "analysisStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeIsNull() {
            addCriterion("analysis_sample_compress_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeIsNotNull() {
            addCriterion("analysis_sample_compress_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeEqualTo(Date value) {
            addCriterion("analysis_sample_compress_start_time =", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeNotEqualTo(Date value) {
            addCriterion("analysis_sample_compress_start_time <>", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeGreaterThan(Date value) {
            addCriterion("analysis_sample_compress_start_time >", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_sample_compress_start_time >=", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeLessThan(Date value) {
            addCriterion("analysis_sample_compress_start_time <", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_sample_compress_start_time <=", value, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeIn(List<Date> values) {
            addCriterion("analysis_sample_compress_start_time in", values, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeNotIn(List<Date> values) {
            addCriterion("analysis_sample_compress_start_time not in", values, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_sample_compress_start_time between", value1, value2, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_sample_compress_start_time not between", value1, value2, "analysisSampleCompressStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeIsNull() {
            addCriterion("analysis_sample_compress_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeIsNotNull() {
            addCriterion("analysis_sample_compress_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeEqualTo(Date value) {
            addCriterion("analysis_sample_compress_end_time =", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeNotEqualTo(Date value) {
            addCriterion("analysis_sample_compress_end_time <>", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeGreaterThan(Date value) {
            addCriterion("analysis_sample_compress_end_time >", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_sample_compress_end_time >=", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeLessThan(Date value) {
            addCriterion("analysis_sample_compress_end_time <", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_sample_compress_end_time <=", value, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeIn(List<Date> values) {
            addCriterion("analysis_sample_compress_end_time in", values, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeNotIn(List<Date> values) {
            addCriterion("analysis_sample_compress_end_time not in", values, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_sample_compress_end_time between", value1, value2, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisSampleCompressEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_sample_compress_end_time not between", value1, value2, "analysisSampleCompressEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeIsNull() {
            addCriterion("analysis_upload_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeIsNotNull() {
            addCriterion("analysis_upload_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeEqualTo(Date value) {
            addCriterion("analysis_upload_start_time =", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeNotEqualTo(Date value) {
            addCriterion("analysis_upload_start_time <>", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeGreaterThan(Date value) {
            addCriterion("analysis_upload_start_time >", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_upload_start_time >=", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeLessThan(Date value) {
            addCriterion("analysis_upload_start_time <", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_upload_start_time <=", value, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeIn(List<Date> values) {
            addCriterion("analysis_upload_start_time in", values, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeNotIn(List<Date> values) {
            addCriterion("analysis_upload_start_time not in", values, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_upload_start_time between", value1, value2, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_upload_start_time not between", value1, value2, "analysisUploadStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeIsNull() {
            addCriterion("analysis_upload_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeIsNotNull() {
            addCriterion("analysis_upload_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeEqualTo(Date value) {
            addCriterion("analysis_upload_end_time =", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeNotEqualTo(Date value) {
            addCriterion("analysis_upload_end_time <>", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeGreaterThan(Date value) {
            addCriterion("analysis_upload_end_time >", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_upload_end_time >=", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeLessThan(Date value) {
            addCriterion("analysis_upload_end_time <", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_upload_end_time <=", value, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeIn(List<Date> values) {
            addCriterion("analysis_upload_end_time in", values, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeNotIn(List<Date> values) {
            addCriterion("analysis_upload_end_time not in", values, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_upload_end_time between", value1, value2, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisUploadEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_upload_end_time not between", value1, value2, "analysisUploadEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeIsNull() {
            addCriterion("analysis_role_recognise_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeIsNotNull() {
            addCriterion("analysis_role_recognise_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeEqualTo(Date value) {
            addCriterion("analysis_role_recognise_start_time =", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeNotEqualTo(Date value) {
            addCriterion("analysis_role_recognise_start_time <>", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeGreaterThan(Date value) {
            addCriterion("analysis_role_recognise_start_time >", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_role_recognise_start_time >=", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeLessThan(Date value) {
            addCriterion("analysis_role_recognise_start_time <", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_role_recognise_start_time <=", value, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeIn(List<Date> values) {
            addCriterion("analysis_role_recognise_start_time in", values, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeNotIn(List<Date> values) {
            addCriterion("analysis_role_recognise_start_time not in", values, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_role_recognise_start_time between", value1, value2, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_role_recognise_start_time not between", value1, value2, "analysisRoleRecogniseStartTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeIsNull() {
            addCriterion("analysis_role_recognise_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeIsNotNull() {
            addCriterion("analysis_role_recognise_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeEqualTo(Date value) {
            addCriterion("analysis_role_recognise_end_time =", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeNotEqualTo(Date value) {
            addCriterion("analysis_role_recognise_end_time <>", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeGreaterThan(Date value) {
            addCriterion("analysis_role_recognise_end_time >", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("analysis_role_recognise_end_time >=", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeLessThan(Date value) {
            addCriterion("analysis_role_recognise_end_time <", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("analysis_role_recognise_end_time <=", value, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeIn(List<Date> values) {
            addCriterion("analysis_role_recognise_end_time in", values, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeNotIn(List<Date> values) {
            addCriterion("analysis_role_recognise_end_time not in", values, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeBetween(Date value1, Date value2) {
            addCriterion("analysis_role_recognise_end_time between", value1, value2, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAnalysisRoleRecogniseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("analysis_role_recognise_end_time not between", value1, value2, "analysisRoleRecogniseEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeIsNull() {
            addCriterion("align_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeIsNotNull() {
            addCriterion("align_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeEqualTo(Date value) {
            addCriterion("align_start_time =", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeNotEqualTo(Date value) {
            addCriterion("align_start_time <>", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeGreaterThan(Date value) {
            addCriterion("align_start_time >", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("align_start_time >=", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeLessThan(Date value) {
            addCriterion("align_start_time <", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("align_start_time <=", value, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeIn(List<Date> values) {
            addCriterion("align_start_time in", values, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeNotIn(List<Date> values) {
            addCriterion("align_start_time not in", values, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeBetween(Date value1, Date value2) {
            addCriterion("align_start_time between", value1, value2, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("align_start_time not between", value1, value2, "alignStartTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeIsNull() {
            addCriterion("align_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeIsNotNull() {
            addCriterion("align_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeEqualTo(Date value) {
            addCriterion("align_end_time =", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeNotEqualTo(Date value) {
            addCriterion("align_end_time <>", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeGreaterThan(Date value) {
            addCriterion("align_end_time >", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("align_end_time >=", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeLessThan(Date value) {
            addCriterion("align_end_time <", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("align_end_time <=", value, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeIn(List<Date> values) {
            addCriterion("align_end_time in", values, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeNotIn(List<Date> values) {
            addCriterion("align_end_time not in", values, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeBetween(Date value1, Date value2) {
            addCriterion("align_end_time between", value1, value2, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andAlignEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("align_end_time not between", value1, value2, "alignEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeIsNull() {
            addCriterion("label_storage_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeIsNotNull() {
            addCriterion("label_storage_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeEqualTo(Date value) {
            addCriterion("label_storage_start_time =", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeNotEqualTo(Date value) {
            addCriterion("label_storage_start_time <>", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeGreaterThan(Date value) {
            addCriterion("label_storage_start_time >", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("label_storage_start_time >=", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeLessThan(Date value) {
            addCriterion("label_storage_start_time <", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("label_storage_start_time <=", value, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeIn(List<Date> values) {
            addCriterion("label_storage_start_time in", values, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeNotIn(List<Date> values) {
            addCriterion("label_storage_start_time not in", values, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeBetween(Date value1, Date value2) {
            addCriterion("label_storage_start_time between", value1, value2, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("label_storage_start_time not between", value1, value2, "labelStorageStartTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeIsNull() {
            addCriterion("label_storage_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeIsNotNull() {
            addCriterion("label_storage_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeEqualTo(Date value) {
            addCriterion("label_storage_end_time =", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeNotEqualTo(Date value) {
            addCriterion("label_storage_end_time <>", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeGreaterThan(Date value) {
            addCriterion("label_storage_end_time >", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("label_storage_end_time >=", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeLessThan(Date value) {
            addCriterion("label_storage_end_time <", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("label_storage_end_time <=", value, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeIn(List<Date> values) {
            addCriterion("label_storage_end_time in", values, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeNotIn(List<Date> values) {
            addCriterion("label_storage_end_time not in", values, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeBetween(Date value1, Date value2) {
            addCriterion("label_storage_end_time between", value1, value2, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andLabelStorageEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("label_storage_end_time not between", value1, value2, "labelStorageEndTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
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