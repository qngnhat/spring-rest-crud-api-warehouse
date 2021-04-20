package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Customer;
import com.nez.entities.Order;
import com.nez.repository.CustomerRepository;

@Component
public class CustomerLogic {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	OrderLogic orderLogic;

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer getCustomerById(int id) {
		return customerRepo.findById(id);
	}

	public Customer saveCustomer(Customer customer) {
		if (customer.getId() == null) {
			customer = generateCode(customer);
		}
		return customerRepo.save(customer);
	}

	public boolean deleteCustomerById(int id) {
		Customer customer = customerRepo.getOne(id);
		if(customer == null) return false;
		List<Order> orders = orderLogic.getOrdersByCustomerId(id);
		for(Order o : orders) {
			o.setCustomer(null);
		}
		customerRepo.delete(customer);
		return true;
	}

	public Customer generateCode(Customer customer) {
		if (customer == null)
			return null;
		return customer;
	}
}
