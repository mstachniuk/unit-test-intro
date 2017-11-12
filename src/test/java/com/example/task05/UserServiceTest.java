package com.example.task05;

import com.example.task02.UserService;
import com.example.user.User;
import com.example.user.UserDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    @Test
    public void shouldCalculateAvgAgeOfUsers() {
        // given

        Set<User> users = new HashSet<>();
        users.add(new User("Max", LocalDate.of(2000, 9, 11)));
        users.add(new User("John", LocalDate.of(2010, 9, 11)));
        UserDao userDao = mock(UserDao.class);
        System.out.println("userDao: " + userDao.getClass().getName());
        given(userDao.getAllUsers()).willReturn(users);
        UserService service = new UserService(userDao);

        // when
        long result = service.calculateNumberOfUsersUsersByName("John");

        // then
        assertEquals(1, result);
    }
}
