package com.playdata.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /*
    *  spring 6.1 이전 방식
    *
    @Bean
    public SecurityFilterChain security(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()    // 인증, 인가 설정 시작
                .requestMatchers("/login", "/signup", "/user").permitAll()  // 해당 주소는 인증, 인가를 요구하지 않음
                .anyRequest().authenticated()   // 나머지는 인증을 요구
                .and()
                .csrf().disable()   // 테스트를 쉽게 하기 위해 csrf 설정 끄기
                .build();
    }
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll())
                .csrf(csrfConfig -> csrfConfig.disable())
                .build();
    }

    // 암호화 비밀번호 저장을 위한 BCryptEncoder 빈 생성
    @Bean
    public BCryptPasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
