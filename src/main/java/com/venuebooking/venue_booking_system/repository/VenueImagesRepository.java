package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venuebooking.venue_booking_system.model.VenueImages;

@Repository
public interface VenueImagesRepository extends CrudRepository<VenueImages, Integer> {

	@Query("FROM VenueImages WHERE venueid=:venueid")
	List<VenueImages> findByVenueId(@Param("venueid") Integer venueid);
	
}
