package com.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Department;
import com.models.DepartmentList;
import com.securityconfig.AuthenticationRequest;
import com.securityconfig.AuthenticationResponse;
import com.service.Departmentservice;

import com.util.JwtUtil;
@RestController
@CrossOrigin(origins ="http://localhost:4200" )
public class DepartmentController {
	
	@Autowired
	
	Departmentservice service;

	// Getting  Hello Message.
	@GetMapping("/hello")
	public String hello() {
		return "Hello Department!!";
	}

	// Adding department details.
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) {
		return this.service.addDept(dept);
	}

	// Fetching all the department details.
	@GetMapping("/findAll")
	public DepartmentList getDepartment() {
		DepartmentList list = new DepartmentList();
		list.setAlldept(this.service.getAlldept());
		return list;
	}

	// Fetching details by using departmentId.
	// In order to avoid NullPointerException we use Optional<>.
	@GetMapping("/findById/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") String id) {
		return this.service.getDepartment(Long.parseLong(id));
	}

	// Updating department details.
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dept) {
		return this.service.updateDepartment(dept);
	}

	// Deleting department by using particular departmentId.
	@DeleteMapping("/delete/{id}")
	public void deleteDepartment(@PathVariable("id") long departmentID) {
		 this.service.deleteDepartment(departmentID);
	}
	
	

	}

