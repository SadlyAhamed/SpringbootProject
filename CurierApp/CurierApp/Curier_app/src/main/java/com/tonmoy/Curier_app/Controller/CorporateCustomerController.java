package com.tonmoy.Curier_app.Controller;

import com.tonmoy.Curier_app.Model.CorporateCustomer;
import com.tonmoy.Curier_app.Repository.CorporateCustomerRepository;
import com.tonmoy.Curier_app.service.CorporateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CorporateCustomerController {
    @Autowired
    CorporateCustomerService service;

    @Autowired
    private CorporateCustomerRepository repo;



    @RequestMapping(value = {"/", "/index", "/home" })
    public String home() {

        return "index";
    }

    @RequestMapping(value =  "/about")
    public String about() {

        return "about";
    }

    @RequestMapping(value =  "/admin")
    public String admin() {

        return "admin";
    }

    @RequestMapping(value = {"/successful"})
    public String msg() {

        return "successful";
    }

    @RequestMapping("/cc_list")
    public String allEmp(Model m) {
        List<CorporateCustomer> ccList = service.getAllCC();
        m.addAttribute("cclist", ccList);
        m.addAttribute("title", "All Corporate Customar");
        return "cc_list";
    }

    @RequestMapping("/cc_delete/{ccId}")
    public String ccDelete(@PathVariable("ccId") Integer ccId) {
        service.deleteCC(ccId);
        return "redirect:/cc_list";
    }
}
