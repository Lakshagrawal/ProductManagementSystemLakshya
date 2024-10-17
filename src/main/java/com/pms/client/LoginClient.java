package com.pms.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.details.UserDetails;
import com.pms.entity.User;
import com.pms.service.impl.UserServiceImpl;

@Component
public class LoginClient {
	@Autowired
	public UserDetails userDetails;
	@Autowired
	public UserServiceImpl userServiceImpl;

    public void signup(Scanner scanner) {
        System.out.println("--- Signup ---");
		System.out.print("Enter first name: ");
		String fname = scanner.nextLine().trim();
		
		System.out.print("Enter last name: ");
		String lname = scanner.nextLine().trim();
		
		System.out.print("Enter email address: ");
		String email = scanner.nextLine().trim();
		
		System.out.print("Enter Mobile number: ");
		long mobileNumber = scanner.nextLong();
		scanner.nextLine();
		
		System.out.print("Enter usrname: ");
		String username = scanner.nextLine().trim();
		
		System.out.print("Enter password: ");
		String password = scanner.nextLine().trim();
		

		System.out.print("Is User is Admin: true/false ");
		boolean isAdmin = scanner.nextBoolean();
		
		// Validate input
		if (username.isEmpty() || password.isEmpty() || fname.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() ) {
		    System.out.println("Username and password cannot be empty.");
		    return;
		} else {
			User usr = new User(fname, lname, email, mobileNumber, username, password, isAdmin);
			userServiceImpl.addRegister(usr);
		}	
		
    }


	@SuppressWarnings("unused")
	public void login(Scanner scanner) {
		System.out.println("--- Login ---");
		System.out.print("Enter username: ");
		String username = scanner.nextLine().trim();
		System.out.print("Enter password: ");
		String password = scanner.nextLine().trim();

		// Validate input
		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("Username and password cannot be empty.");
			return;
		}
		User usr = userServiceImpl.verifyUnameAndPwd(username, password);
		if(usr != null) {
//			if(usr.getIsAdmin() == true) TODO
			if(usr.getAdmin()) {
				userDetails.displayAdminMenu();				
			} else {
				userDetails.displayUserMenu();
			}
		} else {
			return;
		}

	}

	public void forgotPass(Scanner scanner) {
		System.out.println("--- Forgot Password ---");
		System.out.print("Enter Email Id: ");
		String email = scanner.nextLine().trim();

		// Validate input
		if (email.isEmpty()) {
			System.out.println("Email cannot be empty.");
			return;
		}
		userServiceImpl.forgotPassword(email);
	}
}
