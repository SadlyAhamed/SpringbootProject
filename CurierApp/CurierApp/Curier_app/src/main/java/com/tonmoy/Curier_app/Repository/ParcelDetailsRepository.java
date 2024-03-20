package com.tonmoy.Curier_app.Repository;

import com.tonmoy.Curier_app.Model.ParcelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelDetailsRepository extends JpaRepository<ParcelDetails,Integer> {
}
