package io.github.aguileramesa91.usercore.dao;

import io.github.aguileramesa91.usercore.model.User;

import java.util.List;

public interface UserDao {
    void addUser (User user);
    User findById (Long id);
    List<User> findAll();
    void updateUser (User user);
    void deleteUser (Long id);
}
