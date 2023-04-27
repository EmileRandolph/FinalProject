package com.example.checkoutservice.objects;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Order {
    @Id
    private UUID orderId;
    private UUID userId;
    private UUID basketId;

    public Order(UUID userId, UUID basketId) {
        setOrderId(UUID.randomUUID());
        this.userId = userId;
        this.basketId = basketId;
    }


    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getBasketId() {
        return basketId;
    }

    public void setBasketId(UUID basketId) {
        this.basketId = basketId;
    }
}
