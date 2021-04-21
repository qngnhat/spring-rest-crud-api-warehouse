package com.nez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nez.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Customer findById(int id);
	
	@Query("select c from Customer c where c.id=:id")
	public Customer getCustomerById(@Param("id") int id);
}
