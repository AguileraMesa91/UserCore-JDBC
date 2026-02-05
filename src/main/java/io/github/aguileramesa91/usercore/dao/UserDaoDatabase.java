package io.github.aguileramesa91.usercore.dao;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;
import io.github.aguileramesa91.usercore.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoDatabase implements UserDao{
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, last_name, email, age) VALUES (?,?,?,?)";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement declaration = connection.prepareStatement(sql))
        {
            declaration.setString(1, user.getName());
            declaration.setString(2, user.getLastName());
            declaration.setString(3, user.getEmail());
            declaration.setInt(4, user.getAge());

            declaration.executeUpdate();
            System.out.println("User added succeddfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
