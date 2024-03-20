package com.tonmoy.CourierApplication.service;


import com.tonmoy.CourierApplication.model.Employee;
import com.tonmoy.CourierApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository empRepo;





    public void saveEmpDetails(Employee e) {

        empRepo.save(e);
    }





    public void deleteEmpData(int id) {
        empRepo.deleteById(id);
    }





    public List<Employee> getAllEmpDetails() {
        return empRepo.findAll();
    }





    public Employee findEmpById(int id) {
        return empRepo.findById(id).get();

    }




}
