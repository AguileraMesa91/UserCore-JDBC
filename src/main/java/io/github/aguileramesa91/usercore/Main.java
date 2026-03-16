package io.github.aguileramesa91.usercore;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;
import io.github.aguileramesa91.usercore.dao.UserDao;
import io.github.aguileramesa91.usercore.dao.UserDaoDatabase;
import io.github.aguileramesa91.usercore.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //UserDao user = new UserDaoDatabase();
        Scanner sc = new Scanner(System.in);
        boolean exist = false;
        UserDao user = new UserDaoDatabase();

        System.out.println("========= Welcome to control panel =========");
        while (!exist){
            System.out.println("\n--- Select an option ---");
            System.out.println("1. Add user");
            System.out.println("2. Find user by ID");
            System.out.println("3. List all users");
            System.out.println("4. Update user");
            System.out.println("5. Delete user");
            System.out.println("6. Exit");

            if (!sc.hasNextInt()){
                System.out.println("You must enter a number");
                sc.nextLine();
                continue;
            }
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    try{
                        User newUser = new User();
                        System.out.println("Enter name:");
                        newUser.setName(sc.nextLine());
                        System.out.println("Enter last name:");
                        newUser.setLastName(sc.nextLine());
                        System.out.println("Enter email:");
                        newUser.setEmail(sc.nextLine());
                        System.out.println("Enter age:");
                        newUser.setAge(sc.nextInt());
                        sc.nextLine();

                        user.addUser(newUser);
                    } catch (RuntimeException e){
                        System.err.println("Database Error: could not save the user. " + e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Enter the ID to find:");
                        Long id = sc.nextLong();
                        User found = user.findById(id);
                        System.out.println(found != null ? found: "User not found.");
                    } catch (RuntimeException e){
                        System.err.println("Database Error: could not retrieve data. " + e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        System.out.println("--- All users ---");
                        user.findAll().forEach(System.out::println);
                    } catch (RuntimeException e){
                        System.err.println("Database Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Enter the ID of the user to update:");
                        Long updateId = sc.nextLong();
                        sc.nextLine();

                        User userToUpdate = user.findById(updateId);
                        if(userToUpdate != null){
                            System.out.println("User found: " + userToUpdate.getName() + ", " + userToUpdate.getLastName() +
                                    ", " + userToUpdate.getEmail() + ", " + userToUpdate.getAge()) ;
                            System.out.println("Enter new name: ");
                            userToUpdate.setName(sc.nextLine());
                            System.out.println("Enter new last name: ");
                            userToUpdate.setLastName(sc.nextLine());
                            System.out.println("Enter new email: ");
                            userToUpdate.setEmail(sc.nextLine());
                            System.out.println("Enter new age: ");
                            userToUpdate.setAge(sc.nextInt());
                            sc.nextLine();
                            
                            user.updateUser(userToUpdate);
                            System.out.println("User updated successfully!");
                        }
                    } catch (RuntimeException e){
                        System.err.println("Database Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        System.out.println("Enter the ID of the user to delete:");
                        Long deleteId = sc.nextLong();
                        sc.nextLine();

                        User userToDelete = user.findById(deleteId);
                        if(userToDelete != null){
                            System.out.println("User to delete found: " + userToDelete.getName());
                            user.deleteUser(deleteId);
                            System.out.println("User deleted successfully!");
                        }else{
                            System.out.println("Error: Cannot delete. User not found");
                        }
                    } catch (RuntimeException e){
                        System.err.println("Database Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    exist = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("invalid option, try again.");
            }
        }
        sc.close();
    }
}
