package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.models.Department;


@Service
public interface Departmentservice {

	Department addDept(Department dept);

	List<Department> getAlldept();

	Optional<Department> getDepartment(long parseLong);

	Department updateDepartment(Department dept);

	//String deleteDepartment(long parseLong);

	void deleteDepartment(long departmentID);

	

	

	


}