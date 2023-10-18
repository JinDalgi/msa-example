package com.example.apigatewayservice.config;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
//            netty Server 에서는 Tomcat Server 에서의 HttpServletRequest, Response 가 아닌 위와 같이 사용
//            등록된 필터는 yml 파일에 이름 기입

//            pre filter는 그냥 작성하면 돌아감
            System.out.println("Custom pre filter = " + request.getId());
            
//            post filter는 return 구문 속에 코드를 작성해서 만듦
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Custom post filter = status code = " + response.getStatusCode());
            }));
        };
    }

    public static class Config {
        // 응집도를 높히기 위해 내부에 작성
    }
}
