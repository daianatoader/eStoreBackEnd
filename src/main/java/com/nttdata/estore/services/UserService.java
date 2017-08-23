package com.nttdata.estore.services;

import com.nttdata.estore.entities.User;
import com.nttdata.estore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findOne(id);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    public void saveOrUpdateUser(User User) {
        userRepository.save(User);
    }
}
