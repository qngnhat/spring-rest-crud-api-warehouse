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
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("orders")
	public List<Order> showResourcesOrderLists() {
		return orderRepo.findAll();
	}

	@GetMapping("order/{orderId}")
	public Optional<Order> showResourcesOrder(@PathVariable("orderId") int id) {
		return orderRepo.findById(id);
	}

	@PostMapping("order")
	public Order addOrder(@RequestBody Order order) {
		orderRepo.save(order);
		return order;
	}

	@PutMapping("order")
	public Order updateOrder(@RequestBody Order order) {
		orderRepo.save(order);
		return order;
	}

	@DeleteMapping("order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") int id) {
		Order order = orderRepo.getOne(id);
		orderRepo.delete(order);
		return "deleted";
	}
}
