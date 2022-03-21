package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.models.Department;
import com.models.Staff;
import com.repository.DepartmentRepository;
import com.repository.StaffRepository;
import com.service.Departmentservice;
import com.service.Staffservice;

@RunWith(SpringRunner.class)
@SpringBootTest
class OwnerServiceApplicationTests {
	@Autowired
	Departmentservice service;
	@Autowired
Staffservice stfservice;
	@MockBean
	private DepartmentRepository repo;
	@MockBean
	private StaffRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	public void getDepartmentTest() {
		when(repo.findAll())
				.thenReturn((List<Department>) Stream
						.of(new Department(1, "Cooking", "Cooking Decsription", 10),
								new Department(2, "Cleaning", "Cleaning Decsription", 12))
						.collect(Collectors.toList()));
		assertEquals(2, service.getAlldept().size());
	}

	
	/* @Test
	  public void getDepartmentByIdTest() { long departmentId= 1;
	  when(repo.findById(departmentId)).thenReturn(Optional 
			  .of(Stream .of(new Department(1,"Cooking","Cooking Decsription",10))
	  .collect(Collectors.toList()))); 
	  assertEquals(1, service.getDepartment(departmentId));
	  }
	 */

	@Test
	public void addDeptTest() {
		Department dept = new Department(2, "laundry", "laundry Decsription", 11);
		when(repo.insert(dept)).thenReturn(dept);
		assertEquals(dept, service.addDept(dept));
	}

	@Test
	public void updateDeptTest() {
		Department dept = new Department(1, "Cooking", "Cooking Decsription", 10);
		when(repo.save(dept)).thenReturn(dept);
		assertEquals(dept, service.updateDepartment(dept));
	}

	 @Test 
	 public Department deleteDepartment() { 
		 Department dept=new Department(1, "Cooking", "Cooking Decsription", 10);
		  service.deleteDepartment((long)1);
			  verify(repo,times(1)).delete(dept);
			return dept;
			}
	 
}