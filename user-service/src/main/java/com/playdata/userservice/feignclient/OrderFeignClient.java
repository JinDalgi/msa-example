package com.playdata.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-service")
public interface OrderFeignClient {

}