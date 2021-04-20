package com.nez.product;

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

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping("categories")
	public List<Category> showResourcesCategoryLists() {
		return categoryRepo.findAll();
	}

	@GetMapping("category/{categoryId}")
	public Optional<Category> showResourcesCategory(@PathVariable("categoryId") int id) {
		return categoryRepo.findById(id);
	}

	@PostMapping("category")
	public Category addCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;
	}

	@PutMapping("category")
	public Category updateCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;
	}

	@DeleteMapping("category/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int id) {
		Category category = categoryRepo.getOne(id);
		categoryRepo.delete(category);
		return "deleted";
	}
}
