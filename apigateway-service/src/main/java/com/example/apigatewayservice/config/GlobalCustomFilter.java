package com.example.apigatewayservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GlobalCustomFilter extends AbstractGatewayFilterFactory<GlobalCustomFilter.Config> {
    @Override
    public GatewayFilter apply(GlobalCustomFilter.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // pre filter는 작성하면 돌아감
            System.out.println("Global Filter Default Message = " + config.getMsg());

            if (config.isPre()) {
                System.out.println("Global pre Filter = " + request.getId());
            }

            // post filter는 return 구문 안에 작성하여 사용
            return chain.filter(exchange).then(Mono.fromRunnable(() ->{
                if (config.isPost()) {
                    System.out.println("Global post Filter = " + response.getStatusCode());
                }
            }));

        };
    }

    public GlobalCustomFilter() {
        super(Config.class);
    }

    @Getter
    @Setter
    public static class Config {
        private String msg;
        private boolean pre;
        private boolean post;
    }
}
