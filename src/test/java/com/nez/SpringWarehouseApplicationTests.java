package com.nez;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nez.entities.Order;
import com.nez.services.NezService;

@SpringBootTest
class SpringWarehouseApplicationTests {

	@Autowired
	NezService service;
	
	@Test
	void contextLoads() {
		List<Order> findAllOrders = service.findAllOrders();
		assertNotNull(findAllOrders);
	}
}
