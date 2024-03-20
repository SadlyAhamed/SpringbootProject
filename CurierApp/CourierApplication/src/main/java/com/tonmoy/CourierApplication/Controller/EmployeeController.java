package com.tonmoy.CourierApplication.Controller;

import com.tonmoy.CourierApplication.model.Employee;
import com.tonmoy.CourierApplication.service.DepartmentService;
import com.tonmoy.CourierApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@Controller
public class EmployeeController {



    @Autowired
    EmployeeService empService;



    @Autowired
    DepartmentService depService;




    @RequestMapping("/emp_list")
    public String allEmp(Model m) {
        List<Employee> employeeList = empService.getAllEmpDetails();
        m.addAttribute("employeeList", employeeList);
        m.addAttribute("title", "All Employee");
        return "employee_list";

    }



    @RequestMapping("/empRegform")
    public String empSaveForm(Model m) {
        m.addAttribute("emplist", new Employee());
        m.addAttribute("depList", depService.getAllDep());
        m.addAttribute("title", "Add Employee");
        return "empRegform";
    }




    @PostMapping(value = "/emp_save")
    public String empSave(@ModelAttribute("emplist") Employee e, Model m) {
        empService.saveEmpDetails(e);

        return "redirect:/emp_list";
    }




    @RequestMapping("/emp_delete/{id}")
    public String empDelete(@PathVariable("id") Integer id) {
        empService.deleteEmpData(id);
        return "redirect:/emp_list";
    }




    @RequestMapping("/emp_edit/{id}")
    public String empEditForm(@PathVariable("id") Integer id, Model m) {
        Employee e = empService.findEmpById(id);
        m.addAttribute("emplist", e);
        m.addAttribute("depList", depService.getAllDep());
        return "empRegform";
    }



}
