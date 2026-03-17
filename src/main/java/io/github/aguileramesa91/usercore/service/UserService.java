package io.github.aguileramesa91.usercore.service;

import io.github.aguileramesa91.usercore.dao.UserDao;
import io.github.aguileramesa91.usercore.dao.UserDaoDatabase;
import io.github.aguileramesa91.usercore.model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDaoDatabase();

    public void registerUser(User user){
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("Validation Error: Name is required.");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new RuntimeException("Validation Error: Last name is required.");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new RuntimeException("Validation Error: Invalid email format.");
        }
        if (user.getAge() < 0){
            throw new RuntimeException("Validation Error: Invalid age.");
        }
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
            throw new RuntimeException("Validation Error: User ID is required for update.");
        }
        if (userDao.findById(user.getIdUser()) == null){
            throw new RuntimeException("Validation Error: User with ID " + user.getIdUser() + " not found.");
        }
        if(user.getEmail() == null || !user.getEmail().contains(("@"))){
            throw new RuntimeException(("Validation Error: Invalid email format during update."));
        }
        userDao.updateUser(user);
    }
    public void deleteUser (Long id){
        userDao.deleteUser(id);
    }
}
