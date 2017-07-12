package com.example.task05;

import com.example.date.DateProvider;
import com.example.task02.UserService;
import com.example.user.User;
import com.example.user.UserDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
        DateProvider dateProvider = mock(DateProvider.class);
        given(dateProvider.now()).willReturn(LocalDate.of(2017, 10, 12));
        UserService service = new UserService(userDao, dateProvider);

        // when
        double result = service.calculateAvgAgeOfUsers();

        // then
        assertEquals(12, result, 0.001);
    }

//    Przypomnienie, kontrakt między equals() a hashCode()
//        User user1 = new User("John", LocalDate.of(2000, 8, 9));
//        User user2 = new User("John", LocalDate.of(2017, 8, 9));
//
//        user1.equals(user2) to wtedy MUSI BYC TAK:
//            user1.hashCode() == user2.hashCode()
//

}









