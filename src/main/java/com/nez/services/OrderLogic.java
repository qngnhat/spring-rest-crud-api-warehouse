package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Order;
import com.nez.entities.OrderItem;
import com.nez.repository.OrderRepository;

@Component
public class OrderLogic {
	
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	OrderItemLogic orderItemLogic;
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public List<Order> getOrdersByEmployeeId(int id) {
		return orderRepo.getOrdersByEmployeeId(id);
	}
	
	public List<Order> getOrdersByCustomerId(int id) {
		return orderRepo.getOrdersByCustomerId(id);
	}

	public Order getOrderById(int id) {
		return orderRepo.findById(id);
	}

	public Order saveOrder(Order order) {
		if(order.getId() == null) {
			order = generateCode(order);
		}
		return orderRepo.save(order);
	}

	public boolean deleteOrder(int id) {
		Order order = orderRepo.getOne(id);
		if(order == null) return false;
		List<OrderItem> orderItems = orderItemLogic.getOrderItemsByOrderId(id);
		for(OrderItem ot : orderItems) {
			ot.setOrder(null);
		}
		orderRepo.delete(order);
		return true;
	}

	public Order generateCode(Order order) {
		if (order == null) return null;
		return order;
	}

}