package com.playdata.orderservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder @ToString
public class ResponseItemDto {
    private Long id;

    private String productId;

    private String productName;

    private Long stock;

    private Long pricePerItem;

    private LocalDateTime createdAt;
}
