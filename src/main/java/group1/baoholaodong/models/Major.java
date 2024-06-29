package group1.baoholaodong.models;

import java.time.LocalDateTime;
import java.util.List;

public class Major { 

    private int id;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private byte status;
    private List<Product> products;

    // Constructor
    public Major() {}

    // Object
    public Major(int id, String name, String description, LocalDateTime created_at, byte status, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.status = status;
        this.products = products;    
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

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
