package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Staff;



public interface StaffRepository extends MongoRepository<Staff,Long>{

}
