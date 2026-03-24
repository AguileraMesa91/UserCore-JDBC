package io.github.aguileramesa91.usercore.service;

import io.github.aguileramesa91.usercore.dao.UserDao;
import io.github.aguileramesa91.usercore.dao.UserDaoDatabase;
import io.github.aguileramesa91.usercore.model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDaoDatabase();

    public void registerUser(User user){
        validateUser(user);
        userDao.addUser(user);
    }

    public User getUserById (Long id){
        return userDao.findById(id);
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    public void updateUser (User user){
        if (user.getIdUser() == null){
            throw new RuntimeException("Validation Error: user ID is required for update.");
        }
        if (userDao.findById(user.getIdUser()) == null){
            throw new RuntimeException("Validation Error: user with ID " + user.getIdUser() + " not found.");
        }
        validateUser(user);
        userDao.updateUser(user);
    }

    public void deleteUser (Long id){
        userDao.deleteUser(id);
    }

    private void validateUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()){
            throw new RuntimeException("Validation Error: name is required.");
        }
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()){
            throw new RuntimeException("Validation Error: last name is required.");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")){
            throw new RuntimeException("Validation Error: invalid email format.");
        }
        if (user.getAge() < 0) {
            throw new RuntimeException("Validation Error: age cannot be a negative.");
        }
    }
}
