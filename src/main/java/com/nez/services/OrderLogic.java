package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Order;
import com.nez.repository.OrderRepository;

@Component
public class OrderLogic {
	@Autowired
	OrderRepository orderRepo;

	public List<Order> getAllOrders() {
		return orderRepo.findAll();
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
		orderRepo.delete(order);
		return true;
	}

	public Order generateCode(Order order) {
		if (order == null) return null;
		return order;
	}
}