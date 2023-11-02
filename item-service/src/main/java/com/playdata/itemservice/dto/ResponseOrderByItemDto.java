package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.domain.Order;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder @ToString
public class ResponseOrderByItemDto {
    private Long id;

    private String productId;

    private String productName;

    private Long stock;

    private Long pricePerItem;

    private List<Order> orderList;

    // 생성자의 파라미터로 item을 넘기면 DTO로 변환
    public ResponseOrderByItemDto(Item item) {
        this.id = item.getId();
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
