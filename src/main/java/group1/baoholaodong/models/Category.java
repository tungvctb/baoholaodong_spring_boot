package group1.baoholaodong.models;

import java.time.LocalDate;
import java.util.Date;

public class Category {
    private int id;
    private String name;
    private String description;
    private Date created_at;
    private Date updated_at;
    private byte status;
    private int parent_id;

    // Constructor
    public Category() {
    }
    public Category(int id, String name, String description, Date created_at, Date updated_at, byte status, int parent_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = new Date();
        this.updated_at = new Date();
        this.status = status;
        this.parent_id = parent_id;
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

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getParentId() {
        return parent_id;
    }

    public void setParentId(int parent_id) {
        this.parent_id = parent_id;
    }
}
