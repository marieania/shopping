package com.example.shopping.dto;

import com.example.shopping.model.ShoppingCart;

import java.util.List;

public class OrderDTO {
    private String orderNotes;
    private List<ShoppingCart> cartItems;

    public OrderDTO() {
    }

    public OrderDTO(String orderNotes, List<ShoppingCart> cartItems) {
        this.orderNotes = orderNotes;
        this.cartItems = cartItems;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "OrderDTO [orderNotes=" + orderNotes +
                ", cartItems=" + cartItems + "]";
    }
}
