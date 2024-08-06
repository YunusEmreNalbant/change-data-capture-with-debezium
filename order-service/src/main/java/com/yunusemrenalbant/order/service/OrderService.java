package com.yunusemrenalbant.order.service;

import com.yunusemrenalbant.order.model.Order;
import com.yunusemrenalbant.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }
}
