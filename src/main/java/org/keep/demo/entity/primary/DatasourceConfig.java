package org.keep.demo.entity.primary;

import java.util.Date;

public class DatasourceConfig {
    private Long id;

    private String datasourceName;

    private String dbType;

    private String driverClass;

    private String jdbcUrl;

    private String username;

    private Integer poolSize;

    private Integer minIdle;

    private Integer idleTimeout;

    private Byte status;

    private Date createdAt;

    private Date updatedAt;

    private byte[] passwordEncrypted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public byte[] getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(byte[] passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", datasourceName=").append(datasourceName);
        sb.append(", dbType=").append(dbType);
        sb.append(", driverClass=").append(driverClass);
        sb.append(", jdbcUrl=").append(jdbcUrl);
        sb.append(", username=").append(username);
        sb.append(", poolSize=").append(poolSize);
        sb.append(", minIdle=").append(minIdle);
        sb.append(", idleTimeout=").append(idleTimeout);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", passwordEncrypted=").append(passwordEncrypted);
        sb.append("]");
        return sb.toString();
    }
}