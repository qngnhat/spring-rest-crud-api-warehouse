package com.nez.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nez.entities.Product;
import com.nez.repository.ProductRepository;

@Component
public class ProductLogic {

	@Autowired
	ProductRepository productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		return productRepo.getById(id);
	}

	public Product saveProduct(Product product) {
		if(product.getId() == null) {
			product = generateCode(product);
		}
		return productRepo.save(product);
	}

	public String deleteProduct(int id) {
		Product product = productRepo.getOne(id);
		productRepo.delete(product);
		return "deleted";
	}

	public Product generateCode(Product product) {
		if (product == null) return null;
		return product;
	}
}
