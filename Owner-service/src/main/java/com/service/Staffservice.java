package com.service;

import java.util.List;
import java.util.Optional;

import com.models.Staff;





public interface Staffservice {

	Staff addEmp(Staff emp);

	List<Staff> getAllEmp();

	Optional<Staff> getEmp(long parseLong);

	Staff updateEmp(Staff emp);

//	String deleteEmp(long parseLong);
	void deleteEmp(long empId);

}
