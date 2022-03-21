package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Department;

public interface DepartmentRepository extends MongoRepository<Department, Long>{

}
