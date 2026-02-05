package io.github.aguileramesa91.usercore;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;
import io.github.aguileramesa91.usercore.dao.UserDao;
import io.github.aguileramesa91.usercore.dao.UserDaoDatabase;
import io.github.aguileramesa91.usercore.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        UserDao userDao = new UserDaoDatabase ();
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Williams");
        user1.setEmail("jwill@test.com");
        user1.setAge(19);

        try{
            userDao.addUser(user1);
        } catch (RuntimeException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }
}
