package ru.sber.demo.repo.user;

import ru.sber.demo.model.user.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();

    boolean create(User user);
}
