package com.example.msajoinexample.main;

import com.example.msajoinexample.entity.Order;
import com.example.msajoinexample.entity.User;
import com.example.msajoinexample.repository.OrderMapRepository;
import com.example.msajoinexample.repository.OrderRepository;
import com.example.msajoinexample.repository.UserMapRepository;
import com.example.msajoinexample.repository.UserReporitory;

import java.util.List;

// 내부에서 join 형식으로 User가 가지고 있는 구매내역을 가져오기
public class Main {

    public static void main(String[] args) {
        // 맵 형태 자료를 저장소에서 꺼낼 수 있도록 repository 객체 생성
        OrderRepository orderRepository = new OrderMapRepository();
        UserReporitory userReporitory = new UserMapRepository();

        // 구매내역 o
        User user1 = userReporitory.getUserByUserId(1);
        // 구매내역 x
        User user3 = userReporitory.getUserByUserId(3);

        System.out.println(user1);
        System.out.println(user3);

        // 조인처럼 동작시키기 위해서 특정 유저의 구매 내역을 다 가져오기
        List<Order> orderList1 = orderRepository.getOrderByUserId(user1.getUserId());
        List<Order> orderList2 = orderRepository.getOrderByUserId(user3.getUserId());

        System.out.println(orderList1);
        System.out.println(orderList2);
    }
}
