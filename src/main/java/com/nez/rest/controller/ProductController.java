package com.nez.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nez.entities.Product;
import com.nez.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("products")
	public List<Product> showResourcesProductLists() {
		return productRepo.findAll();
	}

	@GetMapping("product/{productId}")
	public Optional<Product> showResourcesProduct(@PathVariable("productId") int id) {
		return productRepo.findById(id);
	}

	@PostMapping("product")
	public Product addProduct(@RequestBody Product product) {
		productRepo.save(product);
		return product;
	}

	@PutMapping("product")
	public Product updateProduct(@RequestBody Product product) {
		productRepo.save(product);
		return product;
	}

	@DeleteMapping("product/{productId}")
	public String deleteProduct(@PathVariable("productId") int id) {
		Product product = productRepo.getOne(id);
		productRepo.delete(product);
		return "deleted";
	}
}
