package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Models.Guest;
import com.repository.GuestRepo;
import com.service.Guestservice;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReceptionistServiceApplicationTests {
@Autowired
Guestservice service;

@MockBean
private GuestRepo repo;
	@Test
	void contextLoads() {
	}
@Test
	public void getGuestTest() {
		when(repo.findAll())
				.thenReturn(Stream
					
						.of(new Guest(1, "Jacob",855679928, "jacob@gmail.com", "Male", "Jubleehills,Hyderabad"),
								new Guest(2,"David",765489362,"david@gmail.com","Male","Hightechcity,Hyderabad"))
										
											
											
											
											
						.collect(Collectors.toList()));
		assertEquals(2, service.getAllGuest().size());
}

	
	
	  @Test public void addGuestTest() { Guest guest = new Guest(1, "Jacob",855679928, "jacob@gmail.com", "Male", "Jubleehills,Hyderabad");
	  when(repo.insert(guest)).thenReturn(guest); assertEquals(guest,
	  service.addGuest(guest)); }
	 
	 
	
	
	@Test
	public void updateGuestTest() {
	Guest guest = new Guest(1, "Jacob",855679928, "jacob@gmail.com", "Male", "Jubleehills,Hyderabad");
	when(repo.save(guest)).thenReturn(guest); 
	assertEquals(guest,service.updateGuest(guest));
	}
	
	
	 @Test 
	 public Guest deleteGuestTest() { 
		 Guest guest=new Guest(1, "Jacob",855679928, "jacob@gmail.com", "Male", "Jubleehills,Hyderabad");
		  service.deleteGuest(1);
			  verify(repo,times(1)).delete(guest);
			return guest;
			}
	
	 

	  

}
