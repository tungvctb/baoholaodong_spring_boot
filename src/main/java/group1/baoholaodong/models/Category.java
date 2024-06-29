package group1.baoholaodong.models;

import io.micrometer.common.lang.Nullable;

import java.sql.Date;

public class Category {
    private int id;
    private String name;
    private String description;
    private Date created_at;
    private Date updated_at;
    private byte status;
    @Nullable
    private Integer parent_id;

    // Constructor
    public Category() {
    }
    public Category(int id, String name, String description, java.sql.Date created_at, java.sql.Date updated_at, byte status, Integer parent_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at =created_at;
        this.updated_at = updated_at;
        this.parent_id = parent_id;
        this.status = status;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(java.sql.Date created_at) {
        this.created_at = created_at;
    }

    public java.sql.Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(java.sql.Date updated_at) {
        this.updated_at = updated_at;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parent_id;
    }

    public void setParentId(Integer parent_id) {
        this.parent_id = parent_id;
    }
}