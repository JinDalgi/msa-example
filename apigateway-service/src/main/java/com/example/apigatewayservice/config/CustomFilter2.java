package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter2 extends AbstractGatewayFilterFactory<CustomFilter2.Config> {
    @Override
    public GatewayFilter apply(CustomFilter2.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            System.out.println("Custom2 pre Filter = " + request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() ->{
                System.out.println("Custom2 post filter = " + response.getStatusCode());
            }));
        };
    }

    public CustomFilter2() {
        super(Config.class);
    }

    public static class Config {

    }
}
