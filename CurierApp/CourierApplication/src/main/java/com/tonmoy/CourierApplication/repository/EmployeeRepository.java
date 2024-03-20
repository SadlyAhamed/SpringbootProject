package com.tonmoy.CourierApplication.repository;

import com.tonmoy.CourierApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
