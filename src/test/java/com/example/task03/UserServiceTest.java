package com.example.task03;

import com.example.date.DateProvider;
import com.example.task02.UserService;
import com.example.user.User;
import com.example.user.UserDao;
import org.junit.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    UserService userService;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterCLass() {
        System.out.println("After class");
    }

    @Before
    public void before() {
        System.out.println("Before");
        UserDao userDao = new TestUserDao();
        DateProvider dateProvider = new TestDateProvider();
        userService = new UserService(userDao, dateProvider);
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void shouldCalculateAvgAgeFor3Person() {
        System.out.println("test 1");
        double result = userService.calculateAvgAgeOfUsers();

        assertEquals(5, result, 0.01);
    }

    @Test
    public void shouldTest2() {
        System.out.println("test 2");
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
