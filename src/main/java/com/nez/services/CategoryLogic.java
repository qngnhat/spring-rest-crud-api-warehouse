package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Category;
import com.nez.repository.CategoryRepository;

@Component
public class CategoryLogic {

	@Autowired
	CategoryRepository categoryRepo;

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

	public boolean deleteCategory(int id) {
		Category category = categoryRepo.getOne(id);
		categoryRepo.delete(category);
		return true;
	}

	public Category generateCode(Category category) {
		if (category == null) return null;
		return category;
	}
}
