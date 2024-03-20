package com.tonmoy.Curier_app.service;

import com.tonmoy.Curier_app.Model.Department;
import com.tonmoy.Curier_app.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo depRepo;

    public void saveDep(Department d) {

        depRepo.save(d);
    }

    public void deleteDep(int depid) {
        depRepo.deleteById(depid);
    }

    public List<Department> getAllDep() {

        return depRepo.findAll();
    }

    public Department findDepById(int depid) {

        return depRepo.findById(depid).get();
    }
}
