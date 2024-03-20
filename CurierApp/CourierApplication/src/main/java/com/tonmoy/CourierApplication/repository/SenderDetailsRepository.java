package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.SenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderDetailsRepository extends JpaRepository<SenderDetails ,Integer> {

    @Query("select u from SenderDetails u where u.email=?1") // HSQL = Hibernate Structure Query Language
    SenderDetails findByEmail(String email);
}
