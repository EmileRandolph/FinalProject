package com.example.ecommercebasket;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

public class Item implements Serializable {
    private static final long serialVersion =1l;
    @Id
    private UUID id;
    private String name;
    private String description;
    private double unitPrice;

    public Item(String name, String description, double unitPrice) {
        id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
