package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RequestCreateItemDto {

    // 영문자, 숫자, 한글 1글자 이상이 들어오면 허용
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]+")
    @NotBlank(message = "상품명은 반드시 입력되어야 합니다.")
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
