package com.example.ecommercebasket;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String basketGuid;

    private List<Item> items = new ArrayList<>();

    public Basket() {
    }

    public Basket(String id) {
        this.setBasketGuid(id);
    }

    public String getBasketGuid() {
        return basketGuid;
    }

    public void setBasketGuid(String basketGuid) {
        this.basketGuid = basketGuid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
