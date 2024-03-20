package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.CorporateToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateTokenRepository extends JpaRepository<CorporateToken,Integer> {
    CorporateToken findByConfirmationToken(String token);
}
