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
@Table(name="OCCATIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VenueOccations {

	@Id
	@GeneratedValue
	int id;
	int venueid;
	String occation;
}
