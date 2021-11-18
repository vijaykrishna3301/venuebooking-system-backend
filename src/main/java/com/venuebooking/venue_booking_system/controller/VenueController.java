package com.venuebooking.venue_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venuebooking.venue_booking_system.model.Venue;
import com.venuebooking.venue_booking_system.model.VenueImages;
import com.venuebooking.venue_booking_system.model.VenueOccations;
import com.venuebooking.venue_booking_system.repository.VenueAmenitiesRepository;
import com.venuebooking.venue_booking_system.repository.VenueCommentRepository;
import com.venuebooking.venue_booking_system.repository.VenueImagesRepository;
import com.venuebooking.venue_booking_system.repository.VenueOccationRepository;
import com.venuebooking.venue_booking_system.repository.VenueRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/venue")
public class VenueController {
	@Autowired
	private VenueRepository venueRepository;
	@Autowired
	VenueCommentRepository venueCommentRepository;
	@Autowired
	VenueAmenitiesRepository venueAmenitiesRepository;
	@Autowired
	VenueOccationRepository venueOccationRepository;
	@Autowired
	VenueImagesRepository venueImagesRepository;
	
	@PostMapping("/addvenue")
	public String createVenue(@RequestBody Venue venues) {
		Venue saved = venueRepository.save(venues);
		VenueImages venueImages= new VenueImages(0,saved.getId(),saved.getImage());
		venueImagesRepository.save(venueImages);
		VenueOccations venueOccations = new VenueOccations(0,saved.getId(),saved.getOccations());
		venueOccationRepository.save(venueOccations);
		return "sucess";
	}
	@PostMapping("/updatevenue")
	public String updateVenue(@RequestBody Venue venues) {
		venueRepository.save(venues);
		return "sucess";
	}
	@GetMapping("/getvenues")
	public List<Venue> getVenues(){
		return (List<Venue>) venueRepository.findAll();
	}
	@GetMapping("/getvenuesbyemail/{email}")
	public List<Venue> getVenuesByEmail(@PathVariable String email){
		return (List<Venue>) venueRepository.findByownerEmailId(email);
	}
	public Venue getVenueById(int id) {
		return venueRepository.findById(id).orElse(null);
	}
	@GetMapping("/getvenue/{id}")
	public ArrayList getVenue(@PathVariable int  id) {
		ArrayList details = new ArrayList();
		details.add(venueRepository.findById(id));
		details.add(venueCommentRepository.findByVenueId(id));
		details.add(venueAmenitiesRepository.findByVenueId(id));
		details.add(venueImagesRepository.findByVenueId(id));
		details.add(venueOccationRepository.findByVenueId(id));
		return details;
	}
}
