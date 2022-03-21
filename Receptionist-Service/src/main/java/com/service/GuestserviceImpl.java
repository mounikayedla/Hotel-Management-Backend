package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.Guest;
import com.repository.GuestRepo;


@Service
public class GuestserviceImpl implements Guestservice {

	@Autowired
	GuestRepo guestRepo;

	@Override
	public Guest addGuest(Guest guest) {
		return guestRepo.insert(guest);
	}

	@Override
	public Guest updateGuest(Guest guest) {
		return guestRepo.save(guest);
	}

//	@Override
	public void deleteGuest(int guestId) {
		guestRepo.deleteById(guestId);
		//return "Deleted Guest Id: " + id;
	}

	@Override
	public Optional<Guest> getGuest(int id) {
		return guestRepo.findById(id);
	}

	@Override
	public List<Guest> getAllGuest() {
		return guestRepo.findAll();
	}

}
