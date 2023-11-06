package com.playdata.itemservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public void getTestMessage(String message) {
        // message가 시간 맞춰서 뽑아낸 메세지
        // 보통 objectMapper를 이용하여 역직렬화
        System.out.println("큐에서 뽑아낸 메세지 : " + message);
    }
}
