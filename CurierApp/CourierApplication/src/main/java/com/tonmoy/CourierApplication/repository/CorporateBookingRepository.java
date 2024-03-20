package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.CorporateBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateBookingRepository extends JpaRepository<CorporateBooking, Integer> {
}
