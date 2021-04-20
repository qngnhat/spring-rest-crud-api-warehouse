package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Category;
import com.nez.entities.Product;
import com.nez.repository.CategoryRepository;

@Component
public class CategoryLogic {

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ProductLogic productLogic;
	
	public List<Category> getAllCategorys() {
		return categoryRepo.findAll();
	}

	public Category getCategoryById(int id) {
		return categoryRepo.findById(id);
	}

	public Category saveCategory(Category category) {
		if(category.getId() == null) {
			category = generateCode(category);
		}
		return categoryRepo.save(category);
	}

	public boolean deleteCategoryById(int id) {
		Category category = categoryRepo.getOne(id);
		if(category == null) return false;
		List<Product> products = productLogic.getProductByCategoryId(id);
		for(Product p : products) {
			p.setCategory(null);
		}
		categoryRepo.delete(category);
		return true;
	}

	public Category generateCode(Category category) {
		if (category == null) return null;
		return category;
	}
}
