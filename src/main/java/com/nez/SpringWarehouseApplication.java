package com.nez;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nez.entities.Order;
import com.nez.entities.OrderItem;
import com.nez.services.NezService;

@SpringBootApplication
public class SpringWarehouseApplication implements CommandLineRunner{

	@Autowired
	NezService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWarehouseApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		OrderItem orderItem = new OrderItem();
		orderItem.setQuantity(2);
		Order order = new Order();
		order.setCustomer(null);
		order.setEmployee(null);
		order.setOrderItems(orderItem);
		
		service.saveOrder(order);
	}

	
	
	
	
}
