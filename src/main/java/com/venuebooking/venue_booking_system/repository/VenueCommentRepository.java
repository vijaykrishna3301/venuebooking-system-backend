package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venuebooking.venue_booking_system.model.VenueComment;

@Repository
public interface VenueCommentRepository extends CrudRepository<VenueComment, Integer> {

	@Query("FROM VenueComment WHERE venueid=:venueid")
	List<VenueComment> findByVenueId(@Param("venueid") Integer venueid);
	
}
