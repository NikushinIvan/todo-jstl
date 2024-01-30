package ru.sber.demo.repo.user;

import ru.sber.demo.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryUserRepoImpl implements UserRepo {
    private final static List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1, "qwe", "123", LocalDate.of(1993, 10, 13)));
        USERS.add(new User(2, "qwer", "123", LocalDate.of(2000, 3, 15)));
    }

    @Override
    public List<User> findAll() {
        return USERS;
    }

    @Override
    public boolean create(User user) {
        if (user == null) {
            return false;
        }
        return USERS.add(user);
    }
}
