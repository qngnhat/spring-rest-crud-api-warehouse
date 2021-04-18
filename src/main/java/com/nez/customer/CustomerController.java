package com.nez.customer;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	private static final String WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM = "customers/createOrUpdateCustomerForm";
	
	private final CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository nezService) {
		this.customerRepository = nezService;
	}
	
	@InitBinder
	public void setAllowrdFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("customers/new")
	public String initCreationForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("customers/new")
	public String processCreationForm(@Valid Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			return WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
		}else {
			this.customerRepository.save(customer);
			return "redirect:/customers/" + customer.getId();
		}
	}
	
	@GetMapping("/customers")
	public String processFindForm(Customer customer, BindingResult result, Map<String, Object> model) {

		if(customer.getLastName() == null) {
			customer.setLastName("");
		}
		
		//find customer by lastname
		Collection<Customer> results = this.customerRepository.findByLastName(customer.getLastName());
		if (results.isEmpty()) {
			// no customers found
			result.rejectValue("lastName", "notFound", "not found");
			return "customers/findCustomers";
		}
		else if (results.size() == 1) {
			// 1 cusomter found
			customer = results.iterator().next();
			return "redirect:/owners/" + customer.getId();
		}
		else {
			// multiple customer found
			model.put("selections", results);
			return "customers/customersList";
		}
	}
}
