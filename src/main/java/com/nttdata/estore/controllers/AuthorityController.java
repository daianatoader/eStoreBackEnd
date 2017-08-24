package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Authority;
import com.nttdata.estore.entities.User;
import com.nttdata.estore.security.AuthorityName;
import com.nttdata.estore.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping(path = "/authorities/{id}")
    public ResponseEntity getAuthority(@PathVariable("id") long id) {
        Authority authority = authorityService.getById(id);
        if (null == authority) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(authority, HttpStatus.OK);
    }

    @PutMapping(path = "/authorities/{id}")
    public ResponseEntity updateAuthority(@PathVariable long id, @RequestBody Authority authority) {
        // TODO check method
        Authority authorityToUpdate = authorityService.getById(id);
        authorityToUpdate = authority;
        authorityService.saveOrUpdateAuthority(authorityToUpdate);
        if (null == authorityToUpdate) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(authorityToUpdate, HttpStatus.OK);
    }

}
