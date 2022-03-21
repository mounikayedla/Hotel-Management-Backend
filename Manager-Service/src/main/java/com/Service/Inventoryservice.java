package com.Service;

import java.util.List;
import java.util.Optional;

import com.Models.Inventory;



public interface Inventoryservice {

	Inventory addInventory(Inventory inv);

	Optional<Inventory> getInventory(long parseLong);

	Inventory updateInventory(Inventory inv);

	void deleteInventory(long inventoryId);

	List<Inventory> getAllInventory();

}