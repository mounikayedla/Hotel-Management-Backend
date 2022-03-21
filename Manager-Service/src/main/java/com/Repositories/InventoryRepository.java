package com.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Models.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, Long>{

}