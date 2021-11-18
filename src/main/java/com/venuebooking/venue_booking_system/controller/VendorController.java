package com.venuebooking.venue_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venuebooking.venue_booking_system.model.Vendor;
import com.venuebooking.venue_booking_system.repository.VendorRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("/addvendor")
	public String createStore(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
		return "sucess";
	}
	@GetMapping("/getvendors")
	public List<Vendor> getStores(){
		return (List<Vendor>) vendorRepository.findAll();
	}
	@GetMapping("/getvendor/{id}")
	public Vendor getVendor(@PathVariable int  id) {
		return (Vendor) vendorRepository.findById(id).orElse(null);
	}
}
