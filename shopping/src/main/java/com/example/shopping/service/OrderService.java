package com.example.shopping.service;

import com.example.shopping.model.Order;
import com.example.shopping.repository.ItemRepository;
import com.example.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
