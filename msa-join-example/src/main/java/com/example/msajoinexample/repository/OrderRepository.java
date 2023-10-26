package com.example.msajoinexample.repository;

import com.example.msajoinexample.entity.Order;

import java.util.List;

public interface OrderRepository {

    // 특정 유저의 전체 구매 내역 얻기
    List<Order> getOrderByUserId(int userId);
}
