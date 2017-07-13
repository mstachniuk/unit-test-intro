package com.example.streams;

import com.example.user.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamExample {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Max", LocalDate.of(2000, 1, 1)));
        users.add(new User("John", LocalDate.of(2010, 1, 1)));
        users.add(new User("Steve", LocalDate.of(1999, 1, 1)));

        users.stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) {
                        LocalDate now = LocalDate.now();
                        long between = ChronoUnit.YEARS.between(user.getBirthday(), now);
                        return between < 18;
                    }
                })
                .forEach(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        System.out.println("Nie pijesz piwa: " + user.getName());
                    }
                });

        users.stream()
                .filter((user) -> {
                    LocalDate now = LocalDate.now();
                    long between = ChronoUnit.YEARS.between(user.getBirthday(), now);
                    return between < 18;
                })
                .forEach(user ->
                        System.out.println("Nie pijesz piwa: " + user.getName()));
    }
}
