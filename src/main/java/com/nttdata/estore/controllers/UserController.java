package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.User;
import com.nttdata.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") long id) {
        User user = userService.getUser(id);
        if (null == user) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{username}")
    public ResponseEntity getByUsername(@PathVariable("username") String username) {
        User user = userService.getByUsername(username);
        if (null == user) {
            return new ResponseEntity("No user found for username " + username, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity createUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity updateUser(@PathVariable long id, @RequestBody User user) {
        // TODO check method
        User oldUser = userService.getUser(id);
        oldUser = user;
        userService.saveOrUpdateUser(oldUser);
        if (null == oldUser) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldUser, HttpStatus.OK);
    }
}
