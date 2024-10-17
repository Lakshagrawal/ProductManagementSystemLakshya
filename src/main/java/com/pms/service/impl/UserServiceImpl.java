package com.pms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.User;
import com.pms.repo.UserRepo;
import com.pms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired 
    private UserRepo userRepo;
    
    @Override
    public void addRegister(User user) {
        try {
            User savedUser = userRepo.save(user);
            if (savedUser != null) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("User registration failed.");
            }
        } catch (Exception e) {
            System.out.println("Error during user registration: " + e.getMessage());
        }
    }

    @Override
    public User verifyUnameAndPwd(String username, String pass) {
        try {
            Optional<User> userOptional = userRepo.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                System.out.println(user.toString());
                if (user.getPassword().equals(pass)) {
                    System.out.println("User logged in as " + (user.getAdmin() ? "Admin" : "User"));
                    return user;
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Error verifying username and password: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public String forgotPassword(String email) {
        try {
            Optional<User> userOptional = userRepo.findByEmail(email);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                return user.getPassword(); // Consider sending a password reset link instead of returning the password
            } else {
                System.out.println("Email not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving password: " + e.getMessage());
        }
        return null;
    }
}
