package com.nez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nez.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Product findById(int id);
	
	@Query(value = "select * from products where category_id = ?1", nativeQuery = true)
	public List<Product> getProductByCategoryId(int id);
	
	@Query(value = "select * from products where supplier_id = ?1", nativeQuery = true)
	public List<Product> getProductBySupplierId(int id);
}
