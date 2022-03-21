package com.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.Models.Inventory;
import com.Models.InventoryList;
import com.Models.Manager;
import com.Models.Room;
import com.Models.RoomList;
import com.Models.Staff;
import com.Models.StaffList;
import com.Service.Inventoryservice;
import com.Service.Staffservice;


//@RequestMapping("/api")
@RestController
@CrossOrigin(origins ="http://localhost:4200" )
public class managerResource {
	
	//-----------------------STAFF CONTROLLER--------------------

	@GetMapping("/show")
	public String mnger() {
	return "Hello manager";
	}
	

	@Autowired
	Staffservice staffService;

	@PostMapping("/addEmp")
	public Staff addEmployee(@RequestBody Staff emp) {
		return this.staffService.addEmp(emp);
	}

	@GetMapping("/getAllEmp")
	public StaffList getAllEmployee() {
		StaffList list = new StaffList();
		list.setAllEmp(this.staffService.getAllEmp());
		return list;
	}

	@GetMapping("/getByEmp/{id}")
	public Optional<Staff> getEmployee(@PathVariable("id") String id) {
		return this.staffService.getEmp(Long.parseLong(id));
	}

	@PutMapping("/updateEmp")
	public Staff updateEmployee(@RequestBody Staff emp) {
		return this.staffService.updateEmp(emp);
	}

	@DeleteMapping("/deleteByEmp/{id}")
	public void deleteEmployee(@PathVariable("id") long empId) {
		 this.staffService.deleteEmp(empId);
	}
	//-----------------------------INVENTORY CONTROLLER------------------------

		@Autowired
		Inventoryservice inventoryService;

		@PostMapping("/addInv")
		public Inventory addInventary(@RequestBody Inventory inv) {
			return this.inventoryService.addInventory(inv);
		}

		@GetMapping("/getAllInv")
		public InventoryList getAllInventory() {
			InventoryList list = new InventoryList();
			list.setAllInventory(this.inventoryService.getAllInventory());
			return list;
		}

		@GetMapping("/getByInv/{id}")
		public Optional<Inventory> getInventory(@PathVariable("id") String id) {
			return this.inventoryService.getInventory(Long.parseLong(id));
		}

		@PutMapping("/updateInv")
		public Inventory updateInventory(@RequestBody Inventory inv) {
			return this.inventoryService.updateInventory(inv);
		}

		@DeleteMapping("/deleteByInv/{id}")
		public void deleteInventory(@PathVariable("id") long inventoryId) {
		 this.inventoryService.deleteInventory(inventoryId);
		}

	//---------------------ROMM CONTROLLER---------------------------

	

		@Autowired
		private RestTemplate restTemplate;

		@PostMapping("/addRoom")
		public Room addRoom(@RequestBody Room room) {
			return restTemplate.postForObject("http://localhost:8086/rooms/addRoom/", room, Room.class);
		}

		@PutMapping("/updateRoom")
		public Room updateRoom(@RequestBody Room room) {
			restTemplate.put("http://localhost:8086/rooms/updateRoom/", room, Room.class);
			return room;
		}

		@DeleteMapping("/delete/{id}")
		public void deleteRoom(@PathVariable("id") long roomId) {
			restTemplate.delete("http://localhost:8086/rooms/delete/" + roomId);
			//return "Deleted room " + id;
		}

		@GetMapping("/findAllRoom")
		public RoomList getRoom() {
			return restTemplate.getForObject("http://localhost:8086/rooms/findAllRoom/", RoomList.class);
		}

		@GetMapping("/findById/{id}")
		public Room getRoom(@PathVariable("id") String id) {
			return restTemplate.getForObject("http://localhost:8086/rooms/findById/" + id, Room.class);
		}

	
//---------------------MANAGER----------------------------
		
	
	@GetMapping("/mng")
	public Manager mng() {
	return new Manager("101","JOHN","john@gmail.com","1234567894","Hyderabad");
	}
	
	
	
}