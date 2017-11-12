package com.example.task02;

import com.example.date.DateProvider;
import com.example.user.User;
import com.example.user.UserDao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public long calculateNumberOfUsersUsersByName(String name) {
        Set<User> users = userDao.getAllUsers();
        long sum = users.stream()
                .map(u -> u.getName())
                .map(n -> n.equals(name))
                .count();
        return  sum;
    }


}


