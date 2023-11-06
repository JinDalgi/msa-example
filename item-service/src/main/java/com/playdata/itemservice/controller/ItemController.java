package com.playdata.itemservice.controller;

import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseBuyItemDto;
import com.playdata.itemservice.dto.ResponseOrderByItemDto;
import com.playdata.itemservice.service.ItemService;
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

    @GetMapping("/health-check")
    public String healthCheck() {
        return "server is available!";
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@Valid @RequestBody RequestCreateItemDto itemDto) {
        itemService.craeteItem(itemDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
