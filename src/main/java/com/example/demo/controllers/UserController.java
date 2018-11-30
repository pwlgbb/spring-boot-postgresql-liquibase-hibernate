package com.example.demo.controllers;

import com.example.demo.persistence.model.Role;
import com.example.demo.persistence.model.User;
import com.example.demo.persistence.repositories.RoleRepository;
import com.example.demo.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Paweł on 2018-11-30.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PutMapping("/users/add/{user}/{role}")
    @Transactional
    public Long saveUser(@PathVariable("user") String user, @PathVariable("role") String role) {
        User u = userRepository.findByName(user);
        Role r = roleRepository.findByName(role);

        if (u == null) {
            u = new User();
            u.setName(user);
            u.setPassword(user + 1);

            userRepository.saveAndFlush(u);
        }

        if (r == null) {
            r = new Role();
            r.setName(role);
        }

        u.getRoles().add(r);
        r.getUsers().add(u);

        userRepository.saveAndFlush(u);

        return u.getId();
    }

    @GetMapping("/users/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
