package com.playdata.itemservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseBuyItemDto;
import com.playdata.itemservice.dto.ResponseOrderByItemDto;
import com.playdata.itemservice.service.ItemService;
import com.rabbitmq.client.impl.Environment;
import feign.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item-service")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 직렬화, 역직렬화 담당 라이브러리.
    private final ObjectMapper objectMapper;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "server is available!";
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@Valid @RequestBody RequestCreateItemDto itemDto) throws JsonProcessingException {
//        itemService.craeteItem(itemDto);
        itemService.publishCreateItemMessage(itemDto);
        return ResponseEntity.ok("메시지큐에 생성 요청 적재 완료!");
    }

//    @GetMapping("/items/{productId}")
//    public ResponseEntity<?> findItemByProductId(@PathVariable String productId) {
//        ResponseBuyItemDto itemDto = itemService.findByProductId(productId);
//
//        return ResponseEntity.ok(itemDto);
//    }

    @GetMapping("/items/all")
    public ResponseEntity<?> findAllItem() {
        return ResponseEntity.ok(itemService.findAllItem());
    }

    @GetMapping("/items/{productId}/orders")
    public ResponseEntity<?> findOrdersByProductId(@PathVariable String productId) {
        ResponseOrderByItemDto dto = itemService.findOrderByItem(productId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/items/{message}/message")
    public ResponseEntity<?> publishTestMessage(@PathVariable String message) {
        itemService.publishTestMessage(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
