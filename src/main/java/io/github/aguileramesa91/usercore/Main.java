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

        User user2 = new User();
        user2.setName("Michael");
        user2.setLastName("Carter");
        user2.setEmail("michael.carter@test.com");
        user2.setAge(27);

        try{
            //userDao.addUser(user2);
            //System.out.println(userDao.findById(1L));
            //System.out.println(userDao.findAll());
            /*User jonn = userDao.findById(1L);
            if (jonn != null){
                System.out.println("Before update: " + jonn.getName());
                jonn.setName("John Benjamin");
                jonn.setEmail("j.benjamin@test.com");
                userDao.updateUser(jonn);
                System.out.println("User update succesfully in the database!");
                User updateJhon = userDao.findById(1L);
                System.out.println("After update: " + updateJhon.getName());
            }else {
                System.out.println("User whith ID 1 not found for update");
            }*/
            System.out.println("Users before deletion: " + userDao.findAll());
            Long idToDelete = 2L;
            userDao.deleteUser(idToDelete);
            System.out.println("User whit ID: " + idToDelete + " deleted succesfully!");
            System.out.println("User after deletion: " + userDao.findAll());

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
