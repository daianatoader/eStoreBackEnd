package com.nttdata.estore.services;

import com.nttdata.estore.entities.Admin;
import com.nttdata.estore.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Iterable<Admin> findAll() {

        return adminRepository.findAll();
    }

    public Admin getAdmin(int id) {
        return adminRepository.findOne(id);
    }

    public void deleteAdmin(int id) {
        adminRepository.delete(id);
    }

    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
