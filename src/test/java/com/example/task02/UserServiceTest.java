package com.example.task02;

import com.example.date.DateProvider;
import com.example.user.User;
import com.example.user.UserDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void shouldCalculateAvgAgeFor3Person() {
        // given
        UserDao userDao = new TestUserDao();
        DateProvider dateProvider = new TestDateProvider();
        UserService userService = new UserService(userDao, dateProvider);

        // when
        double result = userService.calculateAvgAgeOfUsers();

        // then
        assertEquals(5, result, 0.01);
    }

}

class TestUserDao extends UserDao {
    @Override
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        users.add(new User("John", LocalDate.of(2007, 1, 6)));
        users.add(new User("Max", LocalDate.of(2017, 1, 6)));
        return users;
    }
}

class TestDateProvider implements DateProvider {
    @Override
    public LocalDate now() {
        return LocalDate.of(2017, 5, 1);
    }
}
