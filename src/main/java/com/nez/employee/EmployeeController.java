package com.nez.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("employees")
	public List<Employee> showResourcesEmployeeLists() {
		return employeeRepo.findAll();
	}
	
	@GetMapping("employee/{employeeId}")
	public Optional<Employee> showResourcesEmployee(@PathVariable("employeeId") int id) {
		return employeeRepo.findById(id);
	}
	
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
	
	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
	
	@DeleteMapping("employee/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int id) {
		Employee employee = employeeRepo.getOne(id);
		employeeRepo.delete(employee);
		return "deleted";
	}
}
