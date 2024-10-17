package com.pms.details;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.entity.Product;
import com.pms.service.impl.ProductServiceImpl;

@Component
public class UserDetails {
    @Autowired
    private ProductServiceImpl productService; // Assuming ProductServiceImpl is injected here

    public void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Logout");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProduct(scanner);
                    break;
                case "2":
                    viewAllProducts();
                    break;
                case "3":
                    viewProductById(scanner);
                    break;
                case "4":
                    updateProduct(scanner);
                    break;
                case "5":
                    deleteProduct(scanner);
                    break;
                case "6":
                    System.out.println("Logging out...");
                    return; // Exit the menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addProduct(Scanner scanner) {
        try {
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            System.out.println("Enter product price:");
            int price = scanner.nextInt();
            System.out.println("Enter product quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Product product = new Product(name, quantity, price);
            productService.addProduct(product);
            System.out.println("Product added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private void viewAllProducts() {
        try {
            List<Product> products = productService.viewAllProducts();
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println(product.toString());
            }
        } catch (Exception e) {
            System.out.println("Error retrieving product list: " + e.getMessage());
        }
    }

    private void viewProductById(Scanner scanner) {
        try {
            System.out.println("Enter product ID:");
            long productId = scanner.nextLong();
            scanner.nextLine(); // consume newline

            Product product = productService.viewProductById(productId);
            System.out.println("Product Details:");
            System.out.println(product.toString());
        } catch (Exception e) {
            System.out.println("Error retrieving product: " + e.getMessage());
        }
    }

    private void updateProduct(Scanner scanner) {
        try {
        	System.out.println("Enter product id:");
        	long id = scanner.nextLong();
        	scanner.nextLine();
        	
            System.out.println("Enter new product name:");
            String name = scanner.nextLine();
            System.out.println("Enter new product price:");
            int price = scanner.nextInt();
            System.out.println("Enter new product quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Product updatedProduct = new Product(name, quantity, price);
            updatedProduct.setPid(id);
            
            int result = productService.updateProduct(updatedProduct);
            if (result == 1) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Failed to update product.");
            }
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private void deleteProduct(Scanner scanner) {
        try {
            System.out.println("Enter product ID to delete:");
            long productId = scanner.nextLong();
            scanner.nextLine(); // consume newline

            int result = productService.deleteProduct(productId);
            if (result == 1) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Failed to delete product.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    public void displayUserMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== User Menu ===");
            System.out.println("1. View All Products");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllProducts();
                    break;
                case "2":
                    viewProductById(scanner);
                    break;
                case "3":
                    updateProduct(scanner);
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return; // Exit the menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
