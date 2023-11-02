package com.playdata.itemservice.repository;

import com.playdata.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public Optional<Item> findItemByProductId (String productId);
}
