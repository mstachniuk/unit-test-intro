package com.example.task06;

import com.example.task04.StoreUserService;
import com.example.user.User;
import com.example.user.UserDao;
import com.example.user.UserDto;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.BDDMockito.*;

public class StoreUserServiceTest {

    @Test
    public void storeUserService() {
        // given
        UserDao userDao = mock(UserDao.class);
        StoreUserService storeUserService = new StoreUserService(userDao);

        // when
        storeUserService.storeUser("John", LocalDate.of(2017, 11, 11));

        // then
        verify(userDao).save(new User("John", LocalDate.of(2017, 11, 11)));
    }

    @Test
    public void shouldStoreUserService() {
        // given
        UserDao userDao = mock(UserDao.class);
        StoreUserService storeUserService = new StoreUserService(userDao);
//        UserDto userDto = mock(UserDto.class);
//        given(userDto.getName()).willReturn("John");
//        given(userDto.getBirthday()).willReturn("2017-11-11");
//        UserDto userDto = new MockUserDto();
        UserDto userDto = new UserDto();
        userDto.setName("John");
        userDto.setBirthday("2017-11-11");

        // when
        storeUserService.saveUser(userDto);

        // then
        verify(userDao).save(new User("John", LocalDate.of(2017, 11, 11)));
    }

    /**
     * Cos takiego zostanie utoworzone przez mock(UserDto.class).
     */
    class MockUserDto extends UserDto {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public void setName(String name) {
        }

        @Override
        public String getBirthday() {
            return null;
        }

        @Override
        public void setBirthday(String birthday) {
        }
    }
}
