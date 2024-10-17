package com.pms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pms.entity.Product;

@Service
public interface ProductService {
	public void addProduct(Product product);
	public List<Product> viewAllProducts();
	public Product viewProductById(long pid);
	public int updateProduct(Product product);
	public int deleteProduct(long pid);
}
