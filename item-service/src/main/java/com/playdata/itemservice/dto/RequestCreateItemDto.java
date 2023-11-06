package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RequestCreateItemDto {

    // 영문자, 숫자, 한글 1글자 이상이 들어오면 허용
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]+", message = "상품명은 영문, 숫자, 한글로만 구성되어야 합니다.")
    @NotBlank(message = "상품명은 반드시 입력되어야 합니다.")
    @Size(min = 2, max = 16)
    private String productName;

    @NotNull
    @Min(value = 1, message = "1개 이상의 물품을 등록해야 합니다.")
    @Max(value = 9999, message = "등록할 수 있는 물품의 최대 개수는 9999개 입니다.")
    private Long stock;

    @NotNull
    @Min(value = 1, message = "1원 이상의 가격으로 등록해야 합니다.")
    @Max(value = 9999999, message = "물품 하나의 최대 가격은 9999999원 입니다.")
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
