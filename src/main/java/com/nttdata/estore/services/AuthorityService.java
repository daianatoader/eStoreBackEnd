package com.nttdata.estore.services;

import com.nttdata.estore.entities.Authority;
import com.nttdata.estore.repositories.AuthorityRepository;
import com.nttdata.estore.security.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority getById(long id) {
        return authorityRepository.findOne(id);
    }

    public Authority getByName(AuthorityName name) {
        return authorityRepository.findByName(name);
    }

    public void saveOrUpdateAuthority(Authority authority) {
        authorityRepository.save(authority);
    }
}
