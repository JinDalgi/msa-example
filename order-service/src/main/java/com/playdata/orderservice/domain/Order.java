package com.playdata.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)  // 주문코드도 당연히 불변
    private String orderId;

    private Long count;

    @CreatedDate
    @Column(updatable = false)  // 가입시간 불변
    private LocalDateTime createdAt;

    private String userId;

    private String productId;
}
