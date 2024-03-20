package com.tonmoy.CourierApplication.Controller;


import com.tonmoy.CourierApplication.model.Department;
import com.tonmoy.CourierApplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DepartmentController {



//Call DepartmentService Class
    @Autowired
    DepartmentService depService;





    @RequestMapping("/departments")
    public  String allDep(Model m){

        m.addAttribute("viewDep", depService.getAllDep());// Show All Department as a Table
        m.addAttribute("dep", new Department()); // Show save form for Department
        return  "dep_list";
    }






    @PostMapping(value = "/dep_save")
    public  String addDep(@ModelAttribute("dep") Department dep){
        depService.saveDep(dep);
        return  "redirect:/departments";
    }






    @RequestMapping("/dep_delete/{depId}")
    public String cbDelete(@PathVariable("depId") Integer cbId) {
        depService.deleteDep(cbId);
        return "redirect:/departments";
    }





    @RequestMapping("/dep_edit/{depId}")
    public String cbEditForm(@PathVariable("depId") Integer depId, Model m) {
        Department list = depService.findDepById(depId);
        m.addAttribute("dep", list);
        return "dep_list";
    }



}
