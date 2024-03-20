package com.tonmoy.Curier_app.Controller;


import com.tonmoy.Curier_app.Model.Employee;
import com.tonmoy.Curier_app.service.DepartmentService;
import com.tonmoy.Curier_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @Autowired
    DepartmentService depService;


    //this is for get all employee list
    @RequestMapping("/emp_list")
    public String allEmp(Model m) {
        List<Employee> employeeList = empService.getAllEmpDetails();
        m.addAttribute("employeeList", employeeList);
        m.addAttribute("title", "All Employee");
        return "employee_list";

    }
    //this is for get registration form
    @RequestMapping("/empRegform")
    public String empSaveForm(Model m) {
        m.addAttribute("emp_list", new Employee());
        m.addAttribute("depList", depService.getAllDep());
        m.addAttribute("title", "Add Employee");
        return "empRegform";
    }
    //this is for save new one and get all employee list
    @RequestMapping(value = "/emp_save", method = RequestMethod.POST)
    public String empSave(@ModelAttribute("emp_list") Employee e, Model m) {
        empService.saveEmpDetails(e);

        return "redirect:/emp_list";
    }

    //this is for delete an employee by id and get all employee list
    @RequestMapping("/emp_delete/{id}")
    public String empDelete(@PathVariable("id") Integer id) {
        empService.deleteEmpData(id);
        return "redirect:/emp_list";
    }
    //this is for update  by id and get  list
    @RequestMapping("/emp_edit/{id}")
    public String empEditForm(@PathVariable("id") Integer id, Model m) {
        Employee e = empService.findEmpById(id);
        m.addAttribute("emp_list", e);
        m.addAttribute("depList", depService.getAllDep());
        return "empRegform";
    }
}
