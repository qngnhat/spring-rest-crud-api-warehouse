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
import com.nez.repository.CategoryRepository;
import com.nez.repository.CustomerRepository;
import com.nez.repository.EmployeeRepository;
import com.nez.repository.OrderItemRepository;
import com.nez.repository.OrderRepository;
import com.nez.repository.ProductRepository;
import com.nez.repository.SupplierRepository;

@Service
public class NezService {

	//
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	SupplierRepository supplierRepo;
	//
	
	// Category
	@Transactional(readOnly = true)
	public List<Category> getAllCategorys() {
		return categoryRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Category getCategoryById(int id) {
		return categoryRepo.findById(id);
	}

	@Transactional
	public Category saveCategory(Category category) {
		if(category.getId() == null) {
			return null;
			}
		return categoryRepo.save(category);
	}

	@Transactional
	public boolean deleteCategoryById(int id) {
		Category category = categoryRepo.findById(id);
		if(category == null) {
			throw new IllegalArgumentException("category cant found: " + id);
		}
		List<Product> products = productRepo.getProductByCategoryId(id);
		for(Product p : products) {
			p.setCategory(null);
		}
		categoryRepo.delete(category);
		return true;
	}

	// Customer
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Customer getCustomerById(int id) {
		return customerRepo.findById(id);
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		if (customer.getId() == null) {
			return null;
		}
		return customerRepo.save(customer);
	}

	@Transactional
	public boolean deleteCustomerById(int id) {
		Customer customer = customerRepo.findById(id);
		if(null == customer) {
			throw new IllegalArgumentException("customer cant found: " + id);
		}
		List<Order> orders = orderRepo.getOrdersByCustomerId(id);
		for(Order o : orders) {
			o.setCustomer(null);
		}
		customerRepo.delete(customer);
		return true;
	}

	// Employee
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	@Transactional
	public Employee saveEmployee(Employee employee) {
		if (employee.getId() == null) {
			return null;
		}
		return employeeRepo.save(employee);
	}

	@Transactional
	public boolean deleteEmployeeById(int id) {
		Employee employee = employeeRepo.findById(id);
		if(employee==null) {
			throw new IllegalArgumentException("employee cant found: " + id);
		}
		List<Order> orders = orderRepo.getOrdersByEmployeeId(id);
		for(Order o : orders) {
			o.setEmployee(null);
		}
		employeeRepo.delete(employee);
		return true;
	}

	// OrderItem
	@Transactional(readOnly = true)
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepo.findAll();
	}

	@Transactional(readOnly = true)
	public OrderItem getOrderItemById(int id) {
		return orderItemRepo.findById(id);
	}

	@Transactional
	public OrderItem saveOrderItem(OrderItem orderItem) {
		if(orderItem.getId() == null) {
			return null;
		}
		return orderItemRepo.save(orderItem);
	}

	@Transactional
	public boolean deleteOrderItemById(int id) {
		OrderItem orderItem = orderItemRepo.findById(id);
		if(orderItem == null){
			throw new IllegalArgumentException("orderItem cant found: " + id);
		}
		orderItemRepo.delete(orderItem);
		return true;
	}

	@Transactional(readOnly = true)
	public List<OrderItem> getOrderItemsByOrderId(int id){
		return orderItemRepo.getOrderItemsByOrderId(id);
	}
	
	// Order
	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Order getOrderById(int id) {
		return orderRepo.findById(id);
	}

	@Transactional
	public Order saveOrder(Order order) {
		if(order.getId() == null) {
			return null;
		}
		return orderRepo.save(order);
	}

	@Transactional
	public boolean deleteOrder(int id) {
		Order order = orderRepo.findById(id);
		if(order == null) {
			throw new IllegalArgumentException("order cant found: " + id);
		}
		List<OrderItem> orderItems = orderItemRepo.getOrderItemsByOrderId(id);
		for(OrderItem ot : orderItems) {
			ot.setOrder(null);
		}
		orderRepo.delete(order);
		return true;
	}

	// Product
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Product getProductById(int id) {
		return productRepo.findById(id);
	}

	@Transactional
	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			return null;
		}
		return productRepo.save(product);
	}

	@Transactional
	public boolean deleteProduct(int id) {
		Product product = productRepo.findById(id);
		if(product == null) {
			throw new IllegalArgumentException("product cant found: " + id);
		}
		List<OrderItem> orderItems = orderItemRepo.getOrderItemsByProductId(id);
		for(OrderItem ot : orderItems) {
			ot.setProduct(null);
		}
		productRepo.delete(product);
		return true;
	}

	// Supplier
	@Transactional(readOnly = true)
	public List<Supplier> getAllSuppliers() {
		return supplierRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Supplier getSupplierById(int id) {
		return supplierRepo.findById(id);
	}

	@Transactional
	public Supplier saveSupplier(Supplier supplier) {
		if(supplier.getId() == null) {
			return null;
		}
		return supplierRepo.save(supplier);
	}

	@Transactional
	public boolean deleteSupplier(int id) {
		Supplier supplier = supplierRepo.findById(id);
		if(supplier == null) {
			throw new IllegalArgumentException("supplier cant found: " + id);
		}
		List<Product> products = productRepo.getProductBySupplierId(id);
		for(Product p : products) {
			p.setSupplier(null);
		}
		supplierRepo.delete(supplier);
		return true;
	}
}
