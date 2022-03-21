package com.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Models.Staff;

public interface StaffRepository extends MongoRepository<Staff,Long>{

}
