package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Employee;
import com.nez.repository.EmployeeRepository;

@Component
public class EmployeeLogic {

	@Autowired
	EmployeeRepository employeeRepo;

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		if (employee.getId() == null) {
			employee = generateCode(employee);
		}
		return employeeRepo.save(employee);
	}

	public boolean deleteEmployee(int id) {
		Employee employee = employeeRepo.getOne(id);
		employeeRepo.delete(employee);
		return true;
	}

	public Employee generateCode(Employee employee) {
		if (employee == null)
			return null;
		return employee;
	}
}