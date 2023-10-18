package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RequestCreateItemDto {

    private String productName;

    private Long stock;

    private Long pricePerItem;

    public Item toEntity() {
        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .productName(this.productName)
                .stock(this.stock)
                .pricePerItem(this.pricePerItem)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
