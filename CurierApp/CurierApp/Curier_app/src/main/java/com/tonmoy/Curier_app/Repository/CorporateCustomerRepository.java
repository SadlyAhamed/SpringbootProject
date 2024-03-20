package com.tonmoy.Curier_app.Repository;

import com.tonmoy.Curier_app.Model.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

    //    @Query("select u from CorporateCustomer u where u.ccEmail=?1") // HSQL = Hibernate Structure Query Language
    CorporateCustomer findByccEmail(String email); // get one row by email


}
