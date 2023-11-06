package com.playdata.itemservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.domain.Order;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseOrderByItemDto;
import com.playdata.itemservice.feignclient.OrderFeignClient;
import com.playdata.itemservice.repository.ItemRepository;
import com.playdata.itemservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final OrderFeignClient orderFeignClient;
    private final Producer producer;
    private final ObjectMapper objectMapper;

    public void craeteItem(RequestCreateItemDto itemDto) {
        itemRepository.save(itemDto.toEntity());
    }

//    public ResponseBuyItemDto findByProductId(String productId) {
//        Item item = itemRepository.findItemByProductId(productId);
//
//        if (item == null) throw new  RuntimeException("해당 상품을 찾을 수 없습니다.");
//
//        ResponseBuyItemDto dto = new ResponseBuyItemDto(productId);
//
//    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public ResponseOrderByItemDto findOrderByItem(String productId) {
        Item item = itemRepository.findItemByProductId(productId).orElseThrow(
                () -> new RuntimeException(""));

        ResponseOrderByItemDto itemDto = new ResponseOrderByItemDto(item);

        List<Order> orderList = orderFeignClient.getOrderListByProductId(productId);

        itemDto.setOrderList(orderList);

        return itemDto;
    }

    public void publishTestMessage(String message) {
        producer.sendTestMessage(message);
    }

    public void publishCreateItemMessage(RequestCreateItemDto requestCreateItemDto) throws JsonProcessingException {
        // DTO를 json(String)으로 직렬화
        String message = objectMapper.writeValueAsString(requestCreateItemDto);
        producer.sendCreateItemMessage(message);
    }

}
