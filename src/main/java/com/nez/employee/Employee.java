package com.nez.employee;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nez.model.BaseAccount;
import com.nez.order.Order;

@Entity
@Table(name = "employees")
public class Employee extends BaseAccount{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private Set<Order> orders;
	
}
