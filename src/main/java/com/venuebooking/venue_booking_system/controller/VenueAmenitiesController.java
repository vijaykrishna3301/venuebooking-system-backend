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

import com.venuebooking.venue_booking_system.model.VenueAmenities;
import com.venuebooking.venue_booking_system.repository.VenueAmenitiesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/venueamenities")
public class VenueAmenitiesController {
	@Autowired
	VenueAmenitiesRepository venueAmenitiesRepository;
	@PostMapping("/addamenities")
	public String createVenue(@RequestBody VenueAmenities venueAmenities) {
		
		venueAmenitiesRepository.save(venueAmenities);
		return "sucess";
	}
	@GetMapping("/getamenities")
	public List<VenueAmenities> getVenues(){
		return (List<VenueAmenities>) venueAmenitiesRepository.findAll();
	}
	@GetMapping("/getamenities/{id}")
	public List<VenueAmenities> getVenue(@PathVariable int  id) {
		return  venueAmenitiesRepository.findByVenueId(id);
	}

}
