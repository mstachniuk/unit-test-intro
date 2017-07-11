package com.example.task04;

import com.example.user.User;
import com.example.user.UserDao;
import com.example.user.UserDto;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StoreUserServiceTest {

    @Test
    public void shouldSaveUser() {
        // given
        MyUserDao userDao = new MyUserDao();
        StoreUserService service = new StoreUserService(userDao);
        UserDto userDto = new UserDto();
        userDto.setBirthday("2010-07-11");
        userDto.setName("John");

        // when
        service.saveUser(userDto);

        // then
        User actualUser = userDao.getUser();
        assertEquals("John", actualUser.getName());
        assertEquals(LocalDate.of(2010, 07, 11), actualUser.getBirthday());
    }

    @Test
    public void shouldSaveUser2() {
        // given
        MyUserDao userDao = new MyUserDao();
        StoreUserService service = new StoreUserService(userDao);

        // when
        service.storeUser("Max", LocalDate.of(2010, 07, 13));

        // then
        User actualUser = userDao.getUser();
        assertEquals("Max", actualUser.getName());
        assertEquals(LocalDate.of(2010, 07, 13), actualUser.getBirthday());
    }



}

class MyUserDao extends UserDao {
    private User user;

    @Override
    public void save(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
