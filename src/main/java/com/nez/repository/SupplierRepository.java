package com.nez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nez.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	public Supplier findById(int id);
}
