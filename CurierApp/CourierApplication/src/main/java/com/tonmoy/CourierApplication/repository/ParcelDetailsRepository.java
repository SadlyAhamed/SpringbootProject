package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.ParcelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelDetailsRepository  extends JpaRepository<ParcelDetails,Integer> {


}
