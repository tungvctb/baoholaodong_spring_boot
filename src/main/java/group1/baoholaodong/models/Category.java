package group1.baoholaodong.models;

import java.time.LocalDateTime;

public class Category {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private byte status;


    // Constructor
    public Category() {
    }

    public Category(int id, String name, String description, LocalDateTime createAt, LocalDateTime updateAt, byte status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
