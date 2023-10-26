package com.example.msajoinexample.repository;

import com.example.msajoinexample.entity.User;
import com.sun.jdi.LongValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapRepository implements UserReporitory {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();

    public UserMapRepository() {
        User user1 = new User(1, "my", 22);
        User user2 = new User(2, "my2", 33);
        User user3 = new User(3, "my3", 34);
        User user4 = new User(4, "my4", 23);
        User user5 = new User(5, "my5", 26);

        userMap.put(1, user1);
        userMap.put(2, user2);
        userMap.put(3, user3);
        userMap.put(4, user4);
        userMap.put(5, user5);
    }

    @Override
    public User getUserByUserId(int userId) {

        for (int i=0; i<userMap.size(); i++) {
            if(userMap.get(i).getUserId() == userId) {
                return userMap.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {

        List<User> userList = new ArrayList<>();

        for (int i=0; i<userMap.size(); i++) {
            userList.add(userMap.get(i));
        }

        return userList;
    }
}
