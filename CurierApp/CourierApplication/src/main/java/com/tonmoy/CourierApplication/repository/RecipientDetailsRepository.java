package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.RecipientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientDetailsRepository extends JpaRepository<RecipientDetails, Integer> {
}
