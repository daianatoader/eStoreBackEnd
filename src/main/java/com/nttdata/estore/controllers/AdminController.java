package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Admin;
import com.nttdata.estore.repositories.AdminRepository;
import com.nttdata.estore.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/admin")
public class AdminController {

    //@Autowired
    //private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    @GetMapping(path="/allAdmins")
    public @ResponseBody Iterable<Admin> getAllAdmins() {
        // This returns a JSON or XML with the users
        return adminService.findAll();
    }



}
