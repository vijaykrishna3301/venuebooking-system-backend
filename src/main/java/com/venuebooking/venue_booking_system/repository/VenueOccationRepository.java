package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venuebooking.venue_booking_system.model.VenueOccations;

@Repository
public interface VenueOccationRepository extends CrudRepository<VenueOccations, Integer> {

	@Query("FROM VenueOccations WHERE venueid=:venueid")
	List<VenueOccations> findByVenueId(@Param("venueid") Integer venueid);
	
}
