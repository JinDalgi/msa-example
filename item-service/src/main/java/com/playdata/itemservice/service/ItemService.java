package com.playdata.itemservice.service;

import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseBuyItemDto;
import com.playdata.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

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
}
