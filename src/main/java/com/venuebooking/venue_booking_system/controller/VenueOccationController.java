package com.venuebooking.venue_booking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venuebooking.venue_booking_system.model.VenueOccations;
import com.venuebooking.venue_booking_system.repository.VenueOccationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/venueoccation")
public class VenueOccationController {
	@Autowired
	VenueOccationRepository venueOccationRepository;
	@PostMapping("/addoccation")
	public String createVenue(@RequestBody VenueOccations venueOccations) {
		
		venueOccationRepository.save(venueOccations);
		return "sucess";
	}
	@GetMapping("/getoccation")
	public List<VenueOccations> getVenues(){
		return (List<VenueOccations>) venueOccationRepository.findAll();
	}
	@GetMapping("/getoccation/{id}")
	public List<VenueOccations> getVenue(@PathVariable int  id) {
		return  venueOccationRepository.findByVenueId(id);
	}

}
