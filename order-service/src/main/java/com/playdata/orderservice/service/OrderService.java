package com.playdata.orderservice.service;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.dto.ResponseItemDto;
import com.playdata.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(RequestCreateOrderDto requestCreateOrderDto) {
        Order order = requestCreateOrderDto.toEntity();
        orderRepository.save(order);
    }

    // userId를 입력하면 Order 리스트를 넘겨주는 메서드
    public Optional<List<Order>> findOrderByUserId(String userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    public Optional<List<Order>> getOrderByProductId(String productId) {
        return orderRepository.findOrderByProductId(productId);
    }
}
