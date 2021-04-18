package com.nez.customer;

import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Integer>{
	void save(Customer customer);
}
