package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Admin;
import com.nttdata.estore.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/allAdmins")
    public @ResponseBody
    Iterable<Admin> getAllAdmins() {
        return adminService.findAll();
    }
}
