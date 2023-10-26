package com.example.msajoinexample.repository;

import com.example.msajoinexample.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepository implements OrderRepository {

    Map<Integer, Order> orderList;

    // 더미데이터를 맵 형태로 넣어줌
    public OrderMapRepository() {
        this.orderList = new HashMap<Integer, Order>();
        Order order1 = new Order(1, "감자", 3);
        Order order2 = new Order(2, "고구마", 2);
        Order order3 = new Order(3, "감자튀김", 5);
        Order order4 = new Order(4, "그램", 6);
        Order order5 = new Order(5, "오렌지", 7);
        Order order6 = new Order(6, "감자", 3);
        Order order7 = new Order(7, "커피", 5);
        Order order8 = new Order(8, "연필", 33);
        Order order9 = new Order(9, "지우개", 3);
        Order order10 = new Order(10, "모니터", 4);


        orderList.put(1, order1);
        orderList.put(2, order2);
        orderList.put(3, order3);
        orderList.put(4, order4);
        orderList.put(5, order5);
        orderList.put(6, order6);
        orderList.put(7, order7);
        orderList.put(8, order8);
        orderList.put(9, order9);
        orderList.put(10, order10);

    }
    
    @Override
    public List<Order> getOrderByUserId(int userId) {
        List<Order> userOrderList = new ArrayList<>();

        for (int i=1; i<orderList.size()+1; i++) {
            if(orderList.get(i).getUserId() == userId) {
                userOrderList.add(orderList.get(i));
            }
        }

        return userOrderList;
    }
}
