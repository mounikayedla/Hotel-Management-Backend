package com.Room.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Room.Models.Room;
import com.Room.Models.RoomList;
import com.Room.Service.Roomservice;



@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins="http://localhost:4200")
public class RoomController {

	@Autowired
	Roomservice roomService;
	//@Autowired
//	SeqGenerator sequence;

	@GetMapping("/hello")
	public String hello() {
		return "Hello Receptionist";
	}
//
//	@PostMapping("/addRoom")
//	public Room addRoom(@RequestBody Room room) {
//		@RequestMapping(method = RequestMethod.POST, value="/addRoom")
//		//public Room addRoom(@RequestBody Room room) {
//		//room.setRoomId(sequence.getSequenceNumber(room.SEQUENCE_NAME));
//	
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
	//room.insert(roomService.getSequenceNumber(Room.SEQUENCE_NAME));
	return this.roomService.addRoom(room);
	}
	

	@GetMapping("/findAllRoom")
	public RoomList getAllRoom() {

		RoomList list = new RoomList();
		list.setAllRoom(this.roomService.getAllRoom());
		return list;

	}

	@GetMapping("/findById/{id}")
	public Optional<Room> getRoom(@PathVariable("id") String id) {

		return this.roomService.getRoom(Long.parseLong(id));
	}

	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room) {
		return this.roomService.updateRoom(room);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteRoom(@PathVariable ("id")long roomId) {
		 this.roomService.deleteRoom(roomId);
	}

	@GetMapping("/findRoomAvl")
	public RoomList getRoomAvl() {

		return this.roomService.getRoomAvl();

	}
}