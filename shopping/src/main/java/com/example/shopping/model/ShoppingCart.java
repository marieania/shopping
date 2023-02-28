package com.example.shopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int itemId;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(int itemId , int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    @Override
    public String toString() {
        return "ShoppingCart[scId=" + id +
                ", itemId=" + itemId +
                ", qty=" + quantity + "]";
    }
}
