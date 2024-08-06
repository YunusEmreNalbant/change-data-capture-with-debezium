package com.yunusemrenalbant.order.repository;

import com.yunusemrenalbant.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
