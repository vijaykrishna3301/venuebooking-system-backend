package com.venuebooking.venue_booking_system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloWelcome {
	@RequestMapping("/hello")
	public String sayHi() {
		return "vijay";
	}
	@GetMapping("/greeting")
	public String greeting(@RequestHeader("name") String language) {
	    // code that uses the language variable
	    return language;
	}

}
