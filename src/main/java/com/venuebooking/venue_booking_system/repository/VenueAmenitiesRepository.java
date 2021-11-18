package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venuebooking.venue_booking_system.model.VenueAmenities;

@Repository
public interface VenueAmenitiesRepository extends CrudRepository<VenueAmenities, Integer> {

	@Query("FROM VenueAmenities WHERE venueid=:venueid")
	List<VenueAmenities> findByVenueId(@Param("venueid") Integer venueid);
	
}
