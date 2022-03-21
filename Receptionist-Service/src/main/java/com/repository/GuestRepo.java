package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Models.Guest;



@Repository
public interface GuestRepo extends MongoRepository<Guest, Integer> {

}