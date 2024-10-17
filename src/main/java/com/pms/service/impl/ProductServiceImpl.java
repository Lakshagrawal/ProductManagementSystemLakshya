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
		// TODO Auto-generated method stub
		Product save = productRepo.save(product);
		if(save != null) {
			System.out.println("Product is added successfuly");
		} else {
			System.out.println("PRoduct is not added");
		}
		return;
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		List<Product> arr = productRepo.findAll();
		return arr;
	}

	@Override
	public Product viewProductById(long pid) {
		// TODO Auto-generated method stub\
		Optional<Product> product = productRepo.findById(pid);
		Product prod = product.get();
		return prod;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product prod = productRepo.save(product);
		return prod != null ? 1 : 0;
	}

	@Override
	public int deleteProduct(long pid) {
		// TODO Auto-generated method stub
		productRepo.deleteById(pid);
		return 1;
	}

}
