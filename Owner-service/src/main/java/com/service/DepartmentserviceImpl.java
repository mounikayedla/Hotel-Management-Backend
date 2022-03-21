package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Department;
import com.repository.DepartmentRepository;



@Service
public class DepartmentserviceImpl implements Departmentservice {

	// It is used for initializing an interface.
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department addDept(Department dept) {
		return repo.insert(dept);
	}




	@Override
	public Department updateDepartment(Department dept) {
		return repo.save(dept);
	}

	// In order to avoid NullPointerException we use Optional<>.
	@Override
	public Optional<Department> getDepartment(long id) {
		return repo.findById(id);
	}

	@Override
	public List<Department> getAlldept() {
		return repo.findAll();
	}

//	@Override
	public void deleteDepartment(long departmentID) {
		// TODO Auto-generated method stub
		 repo.deleteById(departmentID);
	}


}
