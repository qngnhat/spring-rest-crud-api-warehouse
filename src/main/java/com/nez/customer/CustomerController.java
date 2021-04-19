package com.nez.customer;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {
	private static final String WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM = "customers/createOrUpdateCustomerForm";
	
	@Autowired
	CustomerRepository customerRepo;
	
	public CustomerController(CustomerRepository nezService) {
		this.customerRepo = nezService;
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
			this.customerRepo.save(customer);
			return "redirect:/customers/" + customer.getId();
		}
	}
	
	@GetMapping("/customers.html")
	public String showCustomerList(Map<String, Object> model) {
		Customers customers = new Customers();
		customers.getCustomers().addAll(this.customerRepo.findAll());
		model.put("customers", customers);
		return "customers/customerList";
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public String showResourcesCustomerList() {
		return customerRepo.findAll().toString();
	}
	
	@GetMapping("customers/{customerId}/edit")
	public String initUpdateCustomerForm(@PathVariable("customerId") int customerId, Model model) {
		Customer customer = this.customerRepo.findCustomerById(customerId);
		model.addAttribute(customer);
		return WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/customers/{customerId}/edit")
	public String processUpdateCustomerForm(@Valid Customer customer, BindingResult result,
			@PathVariable("customerId") int customerId) {
		if (result.hasErrors()) {
			return WIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
		}
		else {
			customer.setId(customerId);
			this.customerRepo.save(customer);
			return "redirect:/customers/{customerId}";
		}
	}
	
	@GetMapping("/customers/{customerId}")
	public ModelAndView showCustomer(@PathVariable("customerId") int customerId) {
		ModelAndView mav = new ModelAndView("customers/customerDetails");
		Customer customer = this.customerRepo.findCustomerById(customerId);
		mav.addObject(customer);
		return mav;
	}
	
	@RequestMapping(name = "/customer/{customerId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	public String deleteCustomer(@PathVariable("customerId") int id) {
		Customer customer = customerRepo.findCustomerById(id);
		System.out.println(customer);
		customerRepo.delete(customer);
		return "deleted";
	}

}
