package com.nez.customer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends Repository<Customer, Integer>{
	
	@Query("SELECT DISTINCT customer FROM Customer customer LEFT JOIN FETCH customer.orders WHERE customer.lastName LIKE :lastName%")
	@Transactional(readOnly = true)
	Collection<Customer> findByLastName(@Param("lastName") String lastName);
	
	
	@Query("SELECT customer FROM Customer customer left join fetch customer.orders WHERE customer.id =:id")
	@Transactional(readOnly = true)
	Customer findById(@Param("id") Integer id);
	
	
	void save(Customer customer);
}
