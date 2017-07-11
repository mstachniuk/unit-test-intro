package com.example.task02;

import com.example.date.DateProvider;
import com.example.user.User;
import com.example.user.UserDao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class UserService {

    private UserDao userDao;
    private DateProvider dateProvider;

    public UserService(UserDao userDao, DateProvider dateProvider) {
        this.userDao = userDao;
        this.dateProvider = dateProvider;
    }

    public double calculateAvgAgeOfUsers() {
        Set<User> users = userDao.getAllUsers();
        LocalDate today = dateProvider.now();
//        LocalDate today = LocalDate.now();
        // Java functional version
        long sum = users.stream()
                .map(u -> u.getBirthday())
                .mapToLong(b -> ChronoUnit.YEARS.between(b, today))
                .sum();
        // Java imperative version
//        long sum = 0;
//        for (User user : users) {
//            long yearsBetween = ChronoUnit.YEARS.between(user.getBirthday(), today);
//            sum = sum + yearsBetween;
//        }
        return ((double) sum) / users.size();
    }


}


