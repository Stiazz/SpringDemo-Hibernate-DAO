package ru.rudolf.spring.demo.dao;

import java.util.List;

import ru.rudolf.spring.demo.model.User;


public interface UserDAO {
    List<User> getAll();

    User getOne(String email);

    void add(User user);
}