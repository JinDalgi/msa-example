package com.playdata.userservice.feignclient;

import com.playdata.userservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

            // name : 유레카에 등록된 서비스명, path : 서비스 앞단에 붙는 접두어
@FeignClient(name = "ORDER-SERVICE", path = "order-service")
public interface OrderFeignClient {

    @GetMapping("/orders/{userId}")     // orders/{userId}로 호출을 넣으면,
    public List<Order> getOrderListByUserId(@PathVariable String userId); // 요청을 처리해 줌

}