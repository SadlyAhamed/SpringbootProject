package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

    CorporateCustomer findByccEmail(String email);
}
