package com.venuebooking.venue_booking_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="venues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Venue {
	@Id
	@GeneratedValue
	int id;
	int capacitymin,capacitymax,ratingcount,pincode;
	float rating;
	String name,image,street,city,location,landmark,occations,description,owneremail,state,terms;
	
}
