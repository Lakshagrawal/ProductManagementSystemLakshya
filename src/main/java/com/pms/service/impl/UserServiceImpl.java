package com.pms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.User;
import com.pms.repo.UserRepo;
import com.pms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepo userRepo;
	
	@Override
	public void addRegister(User user) {
		User usr = userRepo.save(user);
		// TODO Auto-generated method stub
		if(usr != null) {
			System.out.println("User is Register success");
		} else {
			System.out.println("User is Not Register");
		}
		
		return;
	}

	@Override
	public User verifyUnameAndPwd(String username, String pass) {
		// TODO Auto-generated method stub
		Optional<User> byUsername = userRepo.findByUsername(username);
		User usr = byUsername.get();
		System.out.println(usr.toString());
		if(usr.getPassword().equals(pass)) {
			System.out.println("user is login as the " + (usr.getAdmin()==true? "Admin" : "User" ));
			return usr;
		} else {
		    System.out.println("User not found");
		}
		return null; 
	}

	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		Optional<User> byEmail = userRepo.findByEmail(email);
		User usr = byEmail.get();
		return usr.getPassword();
	}

}
