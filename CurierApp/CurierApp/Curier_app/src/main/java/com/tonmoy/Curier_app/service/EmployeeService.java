package com.tonmoy.Curier_app.service;

import com.tonmoy.Curier_app.Model.Employee;
import com.tonmoy.Curier_app.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    // method use for save data
    public void saveEmpDetails(Employee e) {

        empRepo.save(e);
    }

    // method use for delete data
    public void deleteEmpData(int id) {
        empRepo.deleteById(id);
    }


    // method use for get all data list
    public List<Employee> getAllEmpDetails() {
        return empRepo.findAll();
    }

    // method use for get data by id
    public Employee findEmpById(int id) {
        return empRepo.findById(id).get();

    }

}
