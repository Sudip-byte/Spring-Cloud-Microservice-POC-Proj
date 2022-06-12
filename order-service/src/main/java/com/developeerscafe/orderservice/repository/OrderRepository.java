package com.developeerscafe.orderservice.repository;


import com.developeerscafe.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
