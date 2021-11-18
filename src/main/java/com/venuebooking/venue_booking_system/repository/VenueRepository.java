package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venuebooking.venue_booking_system.model.Venue;
@Repository
public interface VenueRepository  extends CrudRepository<Venue, Integer>{

	@Query("FROM Venue WHERE owneremail=:emailid")
	List<Venue> findByownerEmailId(@Param("emailid") String emailid);
}
