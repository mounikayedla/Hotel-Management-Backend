package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Models.Reservation;



public interface ReservationRepo extends MongoRepository<Reservation, Long> {

}