package com.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.client.RestTemplate;


import com.models.Department;
import com.models.DepartmentList;
import com.models.InventoryList;
import com.models.RoomList;
import com.models.StaffList;
import com.models.owner;
import com.securityconfig.AuthenticationRequest;
import com.securityconfig.AuthenticationResponse;
import com.securityconfig.UserModel;
import com.securityconfig.UserRepository;
import com.securityconfig.UserService;
import com.service.Departmentservice;

import com.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins ="http://localhost:4200" )
public class OwnerResource {

	@Autowired
	AuthenticationManager authenticates;

	@Autowired
	UserService userservice;
	@Autowired
	UserRepository userrepo;
	@Autowired
	JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
//	@Autowired
//	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@Autowired
	private RestTemplate restTemplate;
	//@ApiOperation(value="the owner")
	@GetMapping("/show")
	//@GetMapping
	public String test() {
	return "Hello Owner";
	}
	@PostMapping("/subs")



	public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authreq)
	{
	String username=authreq.getUsername();
	String password=authreq.getPassword();

	UserModel usermodel =new UserModel();
	usermodel.setUsername(authreq.getUsername());
	usermodel.setPassword(authreq.getPassword());

	try {
	userrepo.save(usermodel);
	}
	catch(Exception e)
	{
	return ResponseEntity.ok("Error during subscription");
	}



	return ResponseEntity.ok("Successfully subcribed "+username);
	}



	@PostMapping("/auth")



	public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{





	String username=authenticationRequest.getUsername();
	String password=authenticationRequest.getPassword();



	try
	{
	authenticates.authenticate(new UsernamePasswordAuthenticationToken(username,password));
	}
	catch(Exception e)
	{
	return ResponseEntity.ok("Error during authentication");
	}



	UserDetails userdetails= userservice.loadUserByUsername(username);



	String generatedToken=jwtutil.generateToken(userdetails);





	return ResponseEntity.ok(generatedToken );
	//return ResponseEntity.ok(new AuthenticationResponse("Successfully subcribed "+username));



	}



	@GetMapping("/test")
	private String testingtoken() {
	try {
	return "Testing Successful...!";
	}
	catch(Exception e) {
	return "Please login first..!";
	}
	}

	@GetMapping("/dashboard")
	private String dashboard() {
	return "Welcome to dashboard...!";
	}
	
	
	

	@GetMapping("/owner")
	public owner onr() {
	return new owner("101","Mounika","mounika@gmail.com","1234567894","Hyderabad");
	}
	@GetMapping("/findAllRoom")
	public RoomList getRoom() {
		return restTemplate.getForObject("http://localhost:8086/rooms/findAllRoom/", RoomList.class);
	}
	@GetMapping("/getAllInv")
	public InventoryList getAllInventory() {
		return restTemplate.getForObject("http://localhost:8085/getAllInv/", InventoryList.class);
	}
	@GetMapping("/getAllEmp")
	public StaffList getAllEmployee() {
		return restTemplate.getForObject("http://localhost:8085/getAllEmp/",StaffList.class);
	}
	}


	

