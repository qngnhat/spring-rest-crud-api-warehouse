package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nez.entities.Category;
import com.nez.entities.Customer;
import com.nez.entities.Employee;
import com.nez.entities.Order;
import com.nez.entities.OrderItem;
import com.nez.entities.Product;
import com.nez.entities.Supplier;

@Service
public class NezService {

	@Autowired
	CategoryLogic categoryLogic;
	@Autowired
	CustomerLogic customerLogic;
	@Autowired
	EmployeeLogic employeeLogic;
	@Autowired
	OrderItemLogic orderItemLogic;
	@Autowired
	OrderLogic orderLogic;
	@Autowired
	ProductLogic productLogic;
	@Autowired
	SupplierLogic supplierLogic;

	// Category
	@Transactional
	public List<Category> getAllCategorys() {
		return categoryLogic.getAllCategorys();
	}

	@Transactional
	public Category getCategoryById(int id) {
		return categoryLogic.getCategoryById(id);
	}

	@Transactional
	public Category saveCategory(Category category) {
		return categoryLogic.saveCategory(category);
	}

	@Transactional
	public boolean deleteCategory(int id) {
		return categoryLogic.deleteCategory(id);
	}

	// Customer
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerLogic.getAllCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return customerLogic.getCustomerById(id);
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerLogic.saveCustomer(customer);
	}

	@Transactional
	public boolean deleteCustomer(int id) {
		return customerLogic.deleteCustomer(id);
	}

	// Employee
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeLogic.getAllEmployees();
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		return employeeLogic.getEmployeeById(id);
	}

	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeLogic.saveEmployee(employee);
	}

	@Transactional
	public boolean deleteEmployee(int id) {
		return employeeLogic.deleteEmployee(id);
	}

	// OrderItem
	@Transactional
	public List<OrderItem> getAllOrderItems() {
		return orderItemLogic.getAllOrderItems();
	}

	@Transactional
	public OrderItem getOrderItemById(int id) {
		return orderItemLogic.getOrderItemById(id);
	}

	@Transactional
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemLogic.saveOrderItem(orderItem);
	}

	@Transactional
	public boolean deleteOrderItem(int id) {
		return orderItemLogic.deleteOrderItem(id);
	}

	// Order
	@Transactional
	public List<Order> getAllOrders() {
		return orderLogic.getAllOrders();
	}

	@Transactional
	public Order getOrderById(int id) {
		return orderLogic.getOrderById(id);
	}

	@Transactional
	public Order saveOrder(Order order) {
		return orderLogic.saveOrder(order);
	}

	@Transactional
	public boolean deleteOrder(int id) {
		return orderLogic.deleteOrder(id);
	}

	// Product
	@Transactional
	public List<Product> getAllProducts() {
		return productLogic.getAllProducts();
	}

	@Transactional
	public Product getProductById(int id) {
		return productLogic.getProductById(id);
	}

	@Transactional
	public Product saveProduct(Product product) {
		return productLogic.saveProduct(product);
	}

	@Transactional
	public boolean deleteProduct(int id) {
		return productLogic.deleteProduct(id);
	}

	// Supplier
	@Transactional
	public List<Supplier> getAllSuppliers() {
		return supplierLogic.getAllSuppliers();
	}

	@Transactional
	public Supplier getSupplierById(int id) {
		return supplierLogic.getSupplierById(id);
	}

	@Transactional
	public Supplier saveSupplier(Supplier supplier) {
		return supplierLogic.saveSupplier(supplier);
	}

	@Transactional
	public boolean deleteSupplier(int id) {
		return supplierLogic.deleteSupplier(id);
	}
}
