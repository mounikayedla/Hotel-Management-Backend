package com.example.demo;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Models.Inventory;
import com.Repositories.InventoryRepository;
import com.Service.Inventoryservice;

@SpringBootTest
class ManagerServiceApplicationTests {

	@Autowired
	Inventoryservice service;
	
	@MockBean
	InventoryRepository repo;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void getInventoryTest() {
		when(repo.findAll())
				.thenReturn(Stream
						.of(new Inventory((long) 123456,"Food",(long) 345678,"Ordering"),
							new Inventory((long) 345678,"Beds",(long) 6980098,"purchasing"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getAllInventory().size());
	}
	
	@Test
	public void addInventoryTest() {
		
			Inventory inv = new Inventory((long) 123456,"Food",(long) 345678,"Ordering");
			when(repo.insert(inv)).thenReturn(inv);
			assertEquals(inv, service.addInventory(inv));
	}
	@Test
	public void updateInventoryTest() {
		Inventory inv = new Inventory((long) 123456,"Food",(long) 345678,"Ordering");
		when(repo.save(inv)).thenReturn(inv);
		assertEquals(inv, service.updateInventory(inv));
	}
}
