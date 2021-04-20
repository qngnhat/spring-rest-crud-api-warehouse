package com.nez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nez.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
