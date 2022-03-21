package com.service;

import java.util.List;
import java.util.Optional;

import com.Models.Guest;



public interface Guestservice {

	Guest addGuest(Guest guest);

	Guest updateGuest(Guest guest);

	void deleteGuest(int guestId);

	Optional<Guest> getGuest(int id);

	List<Guest> getAllGuest();

}