package com.playdata.itemservice.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseBuyItemDto {

    private String productId;

    private String productName;

    Long stock;

    Long pricePerItem;

    String userId;

    String orderId;
}
