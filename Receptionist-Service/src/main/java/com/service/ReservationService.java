package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.Reservation;
import com.repository.ReservationRepo;


@Service
public class ReservationService {



	@Autowired
	private ReservationRepo Repo;


	public List<Reservation> getAllReservation()
	{
	List<Reservation> Rsvn=new ArrayList<>();
	Repo.findAll()
	.forEach(Rsvn::add);
	return Rsvn;
	}

	public void addReservation(Reservation Rsvn) {
		Repo.save(Rsvn);


	}


	public void updateReservation( Reservation Rsvn) {
		Repo.save(Rsvn);

	}
	public void delete(Long bookingId) {
		Repo.deleteById(bookingId);

	}

	public List<Reservation> getResList() {
		// TODO Auto-generated method stub
		return Repo.findAll();
	}

		
	}





	
