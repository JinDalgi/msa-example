package com.playdata.itemservice.feignclient;

import com.playdata.itemservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service")
public interface OrderFeignClient {

    @GetMapping("/orders/{productId}/products")
    public List<Order> getOrderListByProductId(@PathVariable String productId);
}
