package com.nez.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nez.entities.Category;
import com.nez.entities.Customer;
import com.nez.entities.Employee;
import com.nez.entities.Order;
import com.nez.entities.OrderItem;
import com.nez.entities.Product;
import com.nez.entities.Supplier;
import com.nez.services.NezService;

@RestController
@RequestMapping("rest")
public class NezController {

	@Autowired
	NezService service;
	
	// Category
	@GetMapping("categories")
	public List<Category> getAllCategories() { 
		return service.getAllCategorys();
	}

	@GetMapping("category/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") int id) {
		return service.getCategoryById(id);
	}
	
	@PutMapping("category")
	public Category saveOrUpdateCategory(@RequestBody Category category) {
		return service.saveCategory(category);
	}

	@DeleteMapping("category/{categoryId}")
	public boolean deleteCategoryById(@PathVariable("categoryId") int id) {
		return service.deleteCategoryById(id);
	}
	
	// Customer
	@GetMapping("customers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@GetMapping("customer/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") int id) {
		return service.getCustomerById(id);
	}
	
	@PutMapping("customer")
	public Customer saveOrUpdateCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@DeleteMapping("customer/{customerId}")
	public boolean deleteCustomerById(@PathVariable("customerId") int id) {
		return service.deleteCustomerById(id);
	}
	
	// Employee
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@GetMapping("employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") int id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("employee")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@DeleteMapping("employee/{employeeId}")
	public boolean deleteEmployeeById(@PathVariable("employeeId") int id) {
		return service.deleteEmployeeById(id);
	}
	
	// Order
	@GetMapping("orders")
	public List<Order> findAllOrders() {
		return service.findAllOrders();
	}

	@GetMapping("order/{orderId}")
	public Order getOrder(@PathVariable("orderId") int id) {
		return service.getOrderById(id);
	}

	@GetMapping("order/customer/{customerId}")
	public List<Order> getOrdersByCustomerId(@PathVariable("customerId") int id) {
		return service.getOrdersItemsByCustomerId(id);
	}
	
	@GetMapping("order/{orderId}/items")
	public List<OrderItem> getOrderItemsByOrderId(@PathVariable("orderId") int id){
		return service.getOrderItemsByOrderId(id);
	}

	@PutMapping("order")
	public Order saveOrUpdateOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}

	@DeleteMapping("order/{orderId}")
	public boolean deleteOrder(@PathVariable("orderId") int id) {
		return service.deleteOrder(id);
	}
	
	// OrderItem
	@GetMapping("orderItems")
	public List<OrderItem> findAllOrderItems() {
		return service.findAllOrderItems();
	}

	@GetMapping("orderItem/{orderItemId}")
	public OrderItem getOrderItemById(@PathVariable("orderItemId") int id) {
		return service.getOrderItemById(id);
	}
	
	@PutMapping("orderItem")
	public OrderItem saveOrUpdateOrderItem(@RequestBody OrderItem orderItem) {
		return service.saveOrderItem(orderItem);
	}

	@DeleteMapping("orderItem/{orderItemId}")
	public boolean deleteOrderItemById(@PathVariable("orderItemId") int id) {
		return service.deleteOrderItemById(id);
	}
	
	// Product
	@GetMapping("products")
	public List<Product> findAllProducts() {
		return service.findAllProducts();
	}

	@GetMapping("product/{productId}")
	public Product getProductById(@PathVariable("productId") int id) {
		return service.getProductById(id);
	}

	@PutMapping("product")
	public Product saveOrUpdateProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@DeleteMapping("product/{productId}")
	public boolean deleteProduct(@PathVariable("productId") int id) {
		return service.deleteProduct(id);
	}
	
	// Supplier
	@GetMapping("suppliers")
	public List<Supplier> findAllSuppliers() {
		return service.findAllSuppliers();
	}

	@GetMapping("supplier/{supplierId}")
	public Supplier getSupplierById(@PathVariable("supplierId") int id) {
		return service.getSupplierById(id);
	}

	@PutMapping("supplier")
	public Supplier saveOrUpdateSupplier(@RequestBody Supplier supplier) {
		return service.saveSupplier(supplier);
	}

	@DeleteMapping("supplier/{supplierId}")
	public boolean deleteSupplier(@PathVariable("supplierId") int id) {
		return service.deleteSupplier(id);
	}
}
