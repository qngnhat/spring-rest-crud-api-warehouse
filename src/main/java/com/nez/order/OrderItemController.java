package com.nez.order;

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
public class OrderItemController {

	@Autowired
	OrderItemRepository orderItemRepo;

	@GetMapping("orderItems")
	public List<OrderItem> showResourcesOrderItemLists() {
		return orderItemRepo.findAll();
	}

	@GetMapping("orderItem/{orderItemId}")
	public Optional<OrderItem> showResourcesOrderItem(@PathVariable("orderItemId") int id) {
		return orderItemRepo.findById(id);
	}

	@PostMapping("orderItem")
	public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
		orderItemRepo.save(orderItem);
		return orderItem;
	}

	@PutMapping("orderItem")
	public OrderItem updateOrderItem(@RequestBody OrderItem orderItem) {
		orderItemRepo.save(orderItem);
		return orderItem;
	}

	@DeleteMapping("orderItem/{orderItemId}")
	public String deleteOrderItem(@PathVariable("orderItemId") int id) {
		OrderItem orderItem = orderItemRepo.getOne(id);
		orderItemRepo.delete(orderItem);
		return "deleted";
	}

}
