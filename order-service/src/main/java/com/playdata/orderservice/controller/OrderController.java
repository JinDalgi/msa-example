package com.playdata.orderservice.controller;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.service.OrderService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "order-service server is available";
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto) {
        orderService.createOrder(requestCreateOrderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/orders/{userId}")
    public ResponseEntity<?> getOrderListByUserId(@PathVariable String userId) {
        List<Order> orderList = orderService.findOrderByUserId(userId).orElseThrow(
                () -> new RuntimeException("없는 유저 아이디로 조회하셨습니다.")).stream().toList();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/orders/{productId}/products")
    public ResponseEntity<?> getOrderListByProductId(@PathVariable String productId) {
        List<Order> orderList = orderService.getOrderByProductId(productId).orElseThrow(() ->
                new RuntimeException("없는 아이템 입니다."));
        return ResponseEntity.ok(orderList);
    }
}
