package com.playdata.orderservice.controller;

import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "order-service server is available";
    }

    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestCreateOrderDto requestCreateOrderDto) {
        orderService.createOrder(requestCreateOrderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
