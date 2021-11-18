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

import com.venuebooking.venue_booking_system.model.Venue;
import com.venuebooking.venue_booking_system.model.VenueComment;
import com.venuebooking.venue_booking_system.repository.VenueCommentRepository;
import com.venuebooking.venue_booking_system.repository.VenueRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/venuecomment")
public class VenueCommentController {
	@Autowired
	VenueCommentRepository venueCommentRepository;
	@Autowired
	private VenueRepository venueRepository;
	
	@PostMapping("/addcomment")
	public String createVenue(@RequestBody VenueComment venueComment) {
		Venue venue =  venueRepository.findById(venueComment.getVenueid()).orElse(null);
		float rating = venue.getRating()*venue.getRatingcount();
		rating = rating+venueComment.getRating();
		venue.setRatingcount(venue.getRatingcount()+1);
		venue.setRating(rating/venue.getRatingcount());
		venueRepository.save(venue);
		venueCommentRepository.save(venueComment);
		return "sucess";
	}
	@GetMapping("/getcomments")
	public List<VenueComment> getVenues(){
		return (List<VenueComment>) venueCommentRepository.findAll();
	}
	@GetMapping("/getcomments/{id}")
	public List<VenueComment> getVenue(@PathVariable int  id) {
		return  venueCommentRepository.findByVenueId(id);
	}

}
