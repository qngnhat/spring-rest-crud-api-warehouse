package com.nez.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerRepository customerRepo;
	
	@GetMapping("customers")
	public List<Customer> showResourcesCustomerLists() {
		return customerRepo.findAll();
	}
	
	@GetMapping("customer/{customerId}")
	public Optional<Customer> showResourcesCustomer(@PathVariable("customerId") int id) {
		return customerRepo.findById(id);
	}
	
	@PostMapping("customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return customer;
	}
	
	@PutMapping("customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return customer;
	}
	
	@DeleteMapping("customer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int id) {
		Customer customer = customerRepo.getOne(id);
		customerRepo.delete(customer);
		return "deleted";
	}
	
	
	
	
}
