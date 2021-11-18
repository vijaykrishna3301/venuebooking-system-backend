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

import com.venuebooking.venue_booking_system.model.VenueImages;
import com.venuebooking.venue_booking_system.repository.VenueImagesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/venueimages")
public class VenueImagesController {
	@Autowired
	VenueImagesRepository venueImagesRepository;
	@PostMapping("/addimages")
	public String createVenue(@RequestBody VenueImages venueImages) {
		venueImagesRepository.save(venueImages);
		return "sucess";
	}
	@GetMapping("/getimages")
	public List<VenueImages> getVenues(){
		return (List<VenueImages>) venueImagesRepository.findAll();
	}
	@GetMapping("/getimages/{id}")
	public List<VenueImages> getVenue(@PathVariable int  id) {
		return  venueImagesRepository.findByVenueId(id);
	}

}
