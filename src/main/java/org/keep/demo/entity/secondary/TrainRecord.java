package org.keep.demo.entity.secondary;

import java.util.Date;

public class TrainRecord {
    private Integer id;

    private String createUser;

    private Date createdDate;

    private Date updatedTime;

    private Byte status;

    private Byte type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createUser=").append(createUser);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}