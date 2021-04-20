package com.nez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nez.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	public OrderItem findById(int id);
	
	@Query(value = "select * from order_items where order_id = ?1", nativeQuery = true)
	List<OrderItem> getOrderItemsByOrderId(int id);
	
	@Query(value = "select * from order_items where product_id = ?1", nativeQuery = true)
	List<OrderItem> getOrderItemsByProductId(int id);
}
