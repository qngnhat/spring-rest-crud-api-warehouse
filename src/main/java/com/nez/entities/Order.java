package com.nez.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Orders")
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@NotNull
	@DecimalMin(value = "0")
	private int total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp orderDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	@JsonBackReference
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void setOrderItems(OrderItem item) {
		if(orderItems==null) {
			orderItems = new ArrayList<>();
		}
		this.orderItems.add(item);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	public Order() {
	}

	public Order(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
