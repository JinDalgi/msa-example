package com.playdata.orderservice.repository;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.ResponseItemDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findOrderByUserId (String userId);

    Optional<List<Order>> findOrderByProductId (String productId);
}
