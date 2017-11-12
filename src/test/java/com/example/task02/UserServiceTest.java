package com.example.task02;

import com.example.user.User;
import com.example.user.UserDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void shouldCalculateNumberOfMaxName() {
        // given
        UserDao userDao = new TestUserDao();
        UserService userService = new UserService(userDao);

        // when
        long result = userService.calculateNumberOfUsersUsersByName("Max");

        // then
        assertEquals(1, result);
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
