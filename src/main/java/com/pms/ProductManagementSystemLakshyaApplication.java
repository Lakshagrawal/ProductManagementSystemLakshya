package com.pms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pms.client.LoginClient;

@SpringBootApplication
public class ProductManagementSystemLakshyaApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProductManagementSystemLakshyaApplication.class, args);
        LoginClient userDao = ctx.getBean(LoginClient.class);
        
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("=== Product Management System ===");
                System.out.println("1. Signup");
                System.out.println("2. Login");
                System.out.println("3. Forgot Password");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        userDao.signup(scanner);
                        break;
                    case "2":
                        userDao.login(scanner);
                        break;
                    case "3":
                        userDao.forgotPass(scanner);
                        break;
                    case "4":
                        System.out.println("Exiting application.");
                        return; // Exit the loop and close the application
                    default:
                        System.out.println("Invalid option. Please select 1, 2, 3, or 4.");
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Ensure the scanner is closed when the application exits
        }
    }
}
