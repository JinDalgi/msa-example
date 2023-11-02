package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseBuyItemDto {

    private String productId;

    private String productName;

    Long stock;

    Long pricePerItem;

    private String userId;

    private String orderId;
}
