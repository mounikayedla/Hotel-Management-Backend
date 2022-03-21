package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.Staff;
import com.Repositories.StaffRepository;

@Service
public class StaffserviceImpl implements Staffservice {

	@Autowired
	StaffRepository staffmongodbRepo;

	@Override
	public Staff addEmp(Staff emp) {
		return staffmongodbRepo.insert(emp);
	}

	@Override
	public List<Staff> getAllEmp() {
		return staffmongodbRepo.findAll();
	}

	@Override
	public Optional<Staff> getEmp(long parseLong) {
		return staffmongodbRepo.findById(parseLong);
	}

	@Override
	public Staff updateEmp(Staff emp) {
		return staffmongodbRepo.save(emp);
	}

	
	public void deleteEmp(long empId) {
	  staffmongodbRepo.deleteById(empId);
		//return "Deleted employee with ID :" + parseLong;
	}

}
