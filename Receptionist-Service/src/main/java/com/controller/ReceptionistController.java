package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Models.Receptionist;


@RestController
public class ReceptionistController {


	@GetMapping("/receptionist")
	public Receptionist onr() {
	return new Receptionist(1,"Sonia","sonia@gmail.com",1234567894,25000);
	}
}
