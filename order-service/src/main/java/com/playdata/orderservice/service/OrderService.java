package com.playdata.orderservice.service;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(RequestCreateOrderDto requestCreateOrderDto) {
        Order order = requestCreateOrderDto.toEntity();
        orderRepository.save(order);
    }

    // userId를 입력하면 Order 리스트를 넘겨주는 메서드
    public ResponseEntity<?> findOrderByUserId(String userId) {


        return null;
    }
}
