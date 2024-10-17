package com.pms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.Product;
import com.pms.repo.ProductRepo;
import com.pms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void addProduct(Product product) {
		Product savedProduct = productRepo.save(product);
		if (savedProduct != null) {
			System.out.println("Product added successfully.");
		} else {
			System.out.println("Product not added.");
		}
	}

	@Override
	public List<Product> viewAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product viewProductById(long pid) {
		Optional<Product> optionalProduct = productRepo.findById(pid);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			System.out.println("Product not found with ID: " + pid);
			return null; // or throw an exception
		}
	}

	@Override
	public int updateProduct(Product product) {
		if (productRepo.existsById(product.getPid())) { // Assuming Product has a getId() method
			productRepo.save(product);
			return 1; // Update successful
		} else {
			System.out.println("Product not found for update.");
			return 0; // Update failed
		}
	}

	@Override
	public int deleteProduct(long pid) {
		if (productRepo.existsById(pid)) {
			productRepo.deleteById(pid);
			return 1; // Deletion successful
		} else {
			System.out.println("Product not found for deletion.");
			return 0; // Deletion failed
		}
	}
}
