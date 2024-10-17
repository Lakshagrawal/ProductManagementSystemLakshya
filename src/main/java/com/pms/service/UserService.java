package com.pms.service;

import org.springframework.stereotype.Service;

import com.pms.entity.User;

public interface UserService {

	public void addRegister(User user);
	
	public User verifyUnameAndPwd(String email, String pass);
	
	public String forgotPassword(String email);
}
