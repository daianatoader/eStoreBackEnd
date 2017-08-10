package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Admin;
import com.nttdata.estore.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/admins")
    public @ResponseBody Iterable<Admin> getAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping(path = "/admins/{id}")
    public ResponseEntity getAdmin(@PathVariable("id") int id) {
        Admin admin = adminService.getAdmin(id);
        if (admin == null) {
            return new ResponseEntity("No Admin found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @DeleteMapping(path = "/admins/{id}")
    public ResponseEntity deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PostMapping(path = "/admins")
    public ResponseEntity createAdmin(@RequestBody Admin admin) {
        adminService.saveOrUpdateAdmin(admin);
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @PutMapping(path = "/admins/{id}")
    public ResponseEntity updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        Admin oldAdmin = adminService.getAdmin(id);
        oldAdmin = admin;
        adminService.saveOrUpdateAdmin(oldAdmin);
        if (null == oldAdmin) {
            return new ResponseEntity("No Admin found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldAdmin, HttpStatus.OK);
    }
}
