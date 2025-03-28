package org.keep.demo.entity.primary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatasourceConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatasourceConfigExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameIsNull() {
            addCriterion("datasource_name is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameIsNotNull() {
            addCriterion("datasource_name is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameEqualTo(String value) {
            addCriterion("datasource_name =", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotEqualTo(String value) {
            addCriterion("datasource_name <>", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameGreaterThan(String value) {
            addCriterion("datasource_name >", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("datasource_name >=", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLessThan(String value) {
            addCriterion("datasource_name <", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLessThanOrEqualTo(String value) {
            addCriterion("datasource_name <=", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLike(String value) {
            addCriterion("datasource_name like", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotLike(String value) {
            addCriterion("datasource_name not like", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameIn(List<String> values) {
            addCriterion("datasource_name in", values, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotIn(List<String> values) {
            addCriterion("datasource_name not in", values, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameBetween(String value1, String value2) {
            addCriterion("datasource_name between", value1, value2, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotBetween(String value1, String value2) {
            addCriterion("datasource_name not between", value1, value2, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNull() {
            addCriterion("db_type is null");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNotNull() {
            addCriterion("db_type is not null");
            return (Criteria) this;
        }

        public Criteria andDbTypeEqualTo(String value) {
            addCriterion("db_type =", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotEqualTo(String value) {
            addCriterion("db_type <>", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThan(String value) {
            addCriterion("db_type >", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("db_type >=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThan(String value) {
            addCriterion("db_type <", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThanOrEqualTo(String value) {
            addCriterion("db_type <=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLike(String value) {
            addCriterion("db_type like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotLike(String value) {
            addCriterion("db_type not like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIn(List<String> values) {
            addCriterion("db_type in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotIn(List<String> values) {
            addCriterion("db_type not in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeBetween(String value1, String value2) {
            addCriterion("db_type between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotBetween(String value1, String value2) {
            addCriterion("db_type not between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDriverClassIsNull() {
            addCriterion("driver_class is null");
            return (Criteria) this;
        }

        public Criteria andDriverClassIsNotNull() {
            addCriterion("driver_class is not null");
            return (Criteria) this;
        }

        public Criteria andDriverClassEqualTo(String value) {
            addCriterion("driver_class =", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassNotEqualTo(String value) {
            addCriterion("driver_class <>", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassGreaterThan(String value) {
            addCriterion("driver_class >", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassGreaterThanOrEqualTo(String value) {
            addCriterion("driver_class >=", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassLessThan(String value) {
            addCriterion("driver_class <", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassLessThanOrEqualTo(String value) {
            addCriterion("driver_class <=", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassLike(String value) {
            addCriterion("driver_class like", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassNotLike(String value) {
            addCriterion("driver_class not like", value, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassIn(List<String> values) {
            addCriterion("driver_class in", values, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassNotIn(List<String> values) {
            addCriterion("driver_class not in", values, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassBetween(String value1, String value2) {
            addCriterion("driver_class between", value1, value2, "driverClass");
            return (Criteria) this;
        }

        public Criteria andDriverClassNotBetween(String value1, String value2) {
            addCriterion("driver_class not between", value1, value2, "driverClass");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIsNull() {
            addCriterion("jdbc_url is null");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIsNotNull() {
            addCriterion("jdbc_url is not null");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlEqualTo(String value) {
            addCriterion("jdbc_url =", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotEqualTo(String value) {
            addCriterion("jdbc_url <>", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlGreaterThan(String value) {
            addCriterion("jdbc_url >", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("jdbc_url >=", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLessThan(String value) {
            addCriterion("jdbc_url <", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLessThanOrEqualTo(String value) {
            addCriterion("jdbc_url <=", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLike(String value) {
            addCriterion("jdbc_url like", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotLike(String value) {
            addCriterion("jdbc_url not like", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIn(List<String> values) {
            addCriterion("jdbc_url in", values, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotIn(List<String> values) {
            addCriterion("jdbc_url not in", values, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlBetween(String value1, String value2) {
            addCriterion("jdbc_url between", value1, value2, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotBetween(String value1, String value2) {
            addCriterion("jdbc_url not between", value1, value2, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPoolSizeIsNull() {
            addCriterion("pool_size is null");
            return (Criteria) this;
        }

        public Criteria andPoolSizeIsNotNull() {
            addCriterion("pool_size is not null");
            return (Criteria) this;
        }

        public Criteria andPoolSizeEqualTo(Integer value) {
            addCriterion("pool_size =", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeNotEqualTo(Integer value) {
            addCriterion("pool_size <>", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeGreaterThan(Integer value) {
            addCriterion("pool_size >", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pool_size >=", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeLessThan(Integer value) {
            addCriterion("pool_size <", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeLessThanOrEqualTo(Integer value) {
            addCriterion("pool_size <=", value, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeIn(List<Integer> values) {
            addCriterion("pool_size in", values, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeNotIn(List<Integer> values) {
            addCriterion("pool_size not in", values, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeBetween(Integer value1, Integer value2) {
            addCriterion("pool_size between", value1, value2, "poolSize");
            return (Criteria) this;
        }

        public Criteria andPoolSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("pool_size not between", value1, value2, "poolSize");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNull() {
            addCriterion("min_idle is null");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNotNull() {
            addCriterion("min_idle is not null");
            return (Criteria) this;
        }

        public Criteria andMinIdleEqualTo(Integer value) {
            addCriterion("min_idle =", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotEqualTo(Integer value) {
            addCriterion("min_idle <>", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThan(Integer value) {
            addCriterion("min_idle >", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_idle >=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThan(Integer value) {
            addCriterion("min_idle <", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThanOrEqualTo(Integer value) {
            addCriterion("min_idle <=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleIn(List<Integer> values) {
            addCriterion("min_idle in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotIn(List<Integer> values) {
            addCriterion("min_idle not in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleBetween(Integer value1, Integer value2) {
            addCriterion("min_idle between", value1, value2, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotBetween(Integer value1, Integer value2) {
            addCriterion("min_idle not between", value1, value2, "minIdle");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutIsNull() {
            addCriterion("idle_timeout is null");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutIsNotNull() {
            addCriterion("idle_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutEqualTo(Integer value) {
            addCriterion("idle_timeout =", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutNotEqualTo(Integer value) {
            addCriterion("idle_timeout <>", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutGreaterThan(Integer value) {
            addCriterion("idle_timeout >", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("idle_timeout >=", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutLessThan(Integer value) {
            addCriterion("idle_timeout <", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("idle_timeout <=", value, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutIn(List<Integer> values) {
            addCriterion("idle_timeout in", values, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutNotIn(List<Integer> values) {
            addCriterion("idle_timeout not in", values, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("idle_timeout between", value1, value2, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andIdleTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("idle_timeout not between", value1, value2, "idleTimeout");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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