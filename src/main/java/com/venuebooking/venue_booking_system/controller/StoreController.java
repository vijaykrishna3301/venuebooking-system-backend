package com.venuebooking.venue_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venuebooking.venue_booking_system.model.Store;
import com.venuebooking.venue_booking_system.repository.StoreRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreRepository storeRepository;
	
	@PostMapping("/addstore")
	public String createStore(@RequestBody Store store) {
		
		storeRepository.save(store);
		return "sucess";
	}
	@GetMapping("/getStores")
	public List<Store> getStores(){
		return (List<Store>) storeRepository.findAll();
	}
	@GetMapping("/getstore/{id}")
	public Store getStore(@PathVariable int  id) {
		return (Store) storeRepository.findById(id).orElse(null);
	}
}
