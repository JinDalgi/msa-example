package com.playdata.userservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder @ToString
public class Order {

    private Long id;

    private String orderId;

    private Long count;

    private LocalDateTime createdAt;

    private String userId;

    private String productId;
}
