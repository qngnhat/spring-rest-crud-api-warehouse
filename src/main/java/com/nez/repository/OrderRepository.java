package com.nez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nez.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public Order findById(int id);

	@Query(value = "select * from orders where employee_id = ?1", nativeQuery = true)
	public List<Order> getOrdersByEmployeeId(int id);
	
	@Query(value = "select * from orders where customer_id = ?1", nativeQuery = true)
	public List<Order> getOrdersByCustomerId(int id);
}
