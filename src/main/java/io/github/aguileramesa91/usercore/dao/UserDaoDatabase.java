package io.github.aguileramesa91.usercore.dao;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;
import io.github.aguileramesa91.usercore.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id_user = ?";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement declaration =  connection.prepareStatement(sql))
        {
            declaration.setLong(1, id);
            ResultSet result = declaration.executeQuery();
            if(result.next()){
                User user = new User();
                user.setIdUser(result.getLong("id_user"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setAge(result.getInt("age"));
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement declaration = connection.prepareStatement(sql))
        {
            ResultSet result = declaration.executeQuery();
            while (result.next()){
                User user = new User();
                user.setIdUser(result.getLong("id_user"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setAge(result.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, last_name = ?, email = ?, age = ? WHERE id_user = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement declaration = connection.prepareStatement(sql)) {
            declaration.setString(1, user.getName());
            declaration.setString(2, user.getLastName());
            declaration.setString(3, user.getEmail());
            declaration.setInt(4, user.getAge());
            declaration.setLong(5, user.getIdUser());

            declaration.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteUser(Long id) {

    }
}
