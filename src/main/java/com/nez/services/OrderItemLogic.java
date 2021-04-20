package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.OrderItem;
import com.nez.repository.OrderItemRepository;

@Component
public class OrderItemLogic {
	@Autowired
	OrderItemRepository orderItemRepo;

	public List<OrderItem> getAllOrderItems() {
		return orderItemRepo.findAll();
	}
	
	public List<OrderItem> getOrderItemsByProductId(int id) {
		return orderItemRepo.getOrderItemsByProductId(id);
	}
	
	public List<OrderItem> getOrderItemsByOrderId(int id){
		return orderItemRepo.getOrderItemsByOrderId(id);
	}

	public OrderItem getOrderItemById(int id) {
		return orderItemRepo.findById(id);
	}

	public OrderItem saveOrderItem(OrderItem orderItem) {
		if(orderItem.getId() == null) {
			orderItem = generateCode(orderItem);
		}
		return orderItemRepo.save(orderItem);
	}

	public boolean deleteOrderItemById(int id) {
		OrderItem orderItem = orderItemRepo.getOne(id);
		orderItemRepo.delete(orderItem);
		return true;
	}

	public OrderItem generateCode(OrderItem orderItem) {
		if (orderItem == null) return null;
		return orderItem;
	}
}