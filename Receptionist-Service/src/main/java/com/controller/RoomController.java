package com.controller;

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

import com.Models.Room;
import com.Models.RoomList;


@RestController
@CrossOrigin(origins ="http://localhost:4200" )
//@CrossOrigin(origins="*")
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		 restTemplate.postForObject("http://localhost:8086/rooms/addRoom/", room, Room.class);
		 return room;
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

}