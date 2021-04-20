package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.OrderItem;
import com.nez.entities.Product;
import com.nez.repository.ProductRepository;

@Component
public class ProductLogic {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderItemLogic orderItemLogic;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public List<Product> getProductByCategoryId(int id) {
		return productRepo.getProductByCategoryId(id);
	}
	
	public List<Product> getProductBySupplierId(int id) {
		return productRepo.getProductBySupplierId(id);
	}

	public Product getProductById(int id) {
		return productRepo.findById(id);
	}

	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			product = generateCode(product);
		}
		return productRepo.save(product);
	}

	public boolean deleteProduct(int id) {
		Product product = productRepo.getOne(id);
		if(product == null) return false;
		List<OrderItem> orderItems = orderItemLogic.getOrderItemsByProductId(id);
		for(OrderItem ot : orderItems) {
			ot.setProduct(null);
		}
		productRepo.delete(product);
		return true;
	}

	public Product generateCode(Product product) {
		if (product == null)
			return null;
		return product;
	}
}
