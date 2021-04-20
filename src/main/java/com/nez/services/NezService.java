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
	@Transactional(readOnly = true)
	public List<Category> getAllCategorys() {
		return categoryLogic.getAllCategorys();
	}

	@Transactional(readOnly = true)
	public Category getCategoryById(int id) {
		return categoryLogic.getCategoryById(id);
	}

	@Transactional
	public Category saveCategory(Category category) {
		return categoryLogic.saveCategory(category);
	}

	@Transactional
	public boolean deleteCategoryById(int id) {
		return categoryLogic.deleteCategoryById(id);
	}

	// Customer
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return customerLogic.getAllCustomers();
	}

	@Transactional(readOnly = true)
	public Customer getCustomerById(int id) {
		return customerLogic.getCustomerById(id);
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerLogic.saveCustomer(customer);
	}

	@Transactional
	public boolean deleteCustomerById(int id) {
		return customerLogic.deleteCustomerById(id);
	}

	// Employee
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeLogic.getAllEmployees();
	}

	@Transactional(readOnly = true)
	public Employee getEmployeeById(int id) {
		return employeeLogic.getEmployeeById(id);
	}

	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeLogic.saveEmployee(employee);
	}

	@Transactional
	public boolean deleteEmployeeById(int id) {
		return employeeLogic.deleteEmployeeById(id);
	}

	// OrderItem
	@Transactional(readOnly = true)
	public List<OrderItem> getAllOrderItems() {
		return orderItemLogic.getAllOrderItems();
	}

	@Transactional(readOnly = true)
	public OrderItem getOrderItemById(int id) {
		return orderItemLogic.getOrderItemById(id);
	}

	@Transactional
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemLogic.saveOrderItem(orderItem);
	}

	@Transactional
	public boolean deleteOrderItemById(int id) {
		return orderItemLogic.deleteOrderItemById(id);
	}

	@Transactional(readOnly = true)
	public List<OrderItem> getOrderItemsByOrderId(int id){
		return orderItemLogic.getOrderItemsByOrderId(id);
	}
	// Order
	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		return orderLogic.getAllOrders();
	}

	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		return productLogic.getAllProducts();
	}

	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<Supplier> getAllSuppliers() {
		return supplierLogic.getAllSuppliers();
	}

	@Transactional(readOnly = true)
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
