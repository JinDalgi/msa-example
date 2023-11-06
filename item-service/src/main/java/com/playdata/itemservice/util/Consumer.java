package com.playdata.itemservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;
    private final ItemService itemService;

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public void createItem(String message) throws JsonProcessingException {
        // message가 시간 맞춰서 뽑아낸 메세지
        // 보통 objectMapper를 이용하여 역직렬화

        // 1. objectMapper.readValue("String 형식인 json", 목적객체.class);
        RequestCreateItemDto dto = objectMapper.readValue(message, RequestCreateItemDto.class);
        // 2. service에서 DTO를 입력받아 DB에 INSERT
        itemService.createItem(dto);
    }
}
