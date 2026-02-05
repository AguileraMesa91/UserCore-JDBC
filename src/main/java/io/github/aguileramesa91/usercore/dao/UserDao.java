package io.github.aguileramesa91.usercore.dao;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;
import io.github.aguileramesa91.usercore.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addUser (User user);
    User findById (Long id);
    List<User> findAll();
    void updateUser (User user);
    void deleteUser (Long id);
}
