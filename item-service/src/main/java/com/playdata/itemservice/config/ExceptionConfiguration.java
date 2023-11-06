package com.playdata.itemservice.config;

import com.playdata.itemservice.util.CustomFeignException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfiguration {

    @Bean
    public CustomFeignException getCustomFeignException() {
        return new CustomFeignException();
    }
}
