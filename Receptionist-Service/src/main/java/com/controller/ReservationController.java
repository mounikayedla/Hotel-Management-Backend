package com.controller;

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

import com.Models.Reservation;
import com.Models.ReservationList;

import com.service.ReservationService;




@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	public List<Reservation> getAllReservation()
	{
		return service.getAllReservation();	
	}
	@GetMapping("/ShowAllReservations")
	public ReservationList getResList() {
	ReservationList list = new ReservationList();
	list.setResList(this.service.getResList());
		return list;
	}
	@RequestMapping(method = RequestMethod.POST, value="/addReservation")
	public void addReservation(@RequestBody Reservation Rsvn)
	{
		service.addReservation(Rsvn);
	   
	}
	@RequestMapping(method=RequestMethod.PUT,value="/updateReservation")
	public void updateReservation(@RequestBody Reservation Rsvn)
	{
		service.updateReservation(Rsvn);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteReservation/{id}")
	public void delete(@PathVariable ("id")Long bookingId)
	{
		service.delete(bookingId);
	}
	}







//
//@GetMapping("/hello")
//public String hello() {
//	return "Reservation Microservice";
//}

//@PostMapping("/addReservation")
//public String addReservation(@RequestBody Reservation book) {
//
//	return this.service.addReservation(book);
//}
//
//@PutMapping("/updateReservation")
//public Reservation updateReservation(@RequestBody Reservation book) {
//return this.service.updateReservation(book);
//}
////
////@DeleteMapping("/deleteReservation/{id}")
////public String deleteReservation(@PathVariable("id") String id) {
////	return this.service.deleteReservation(Long.parseLong(id));
////}
////@RequestMapping(method=RequestMethod.PUT,value="/Reservation/{id}")
////public void addReservation(@RequestBody Reservation Rsvn,@PathVariable Long bookingId)
////{
////	service.updateReservation(bookingId,Rsvn);
////}
//@RequestMapping(method = RequestMethod.DELETE, value="/deleteReservation/{id}")
//public void deleteReservation(@PathVariable Long bookingId)
//{
//service.deleteReservation(bookingId);
//}
//@RequestMapping(method=RequestMethod.POST,value="/addReceptionist")
//public void addReservation(@RequestBody Reservation room)
//{
//	service.addReservation(room);
//
//}
//@GetMapping("/ShowAllReservations")
//public ReservationList getResList() {
//	ReservationList list = new ReservationList();
//	list.setResList(this.service.getResList());
//	return list;
//}
//
//@GetMapping("/getByreservation/{id}")
//public Optional<Reservation> getReservation(@PathVariable("id") String id) {
//	return this.service.getReservation(Long.parseLong(id));
//}
//
