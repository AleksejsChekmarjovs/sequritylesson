package de.telran.g_10_170123_e_be_security.controller;


import de.telran.g_10_170123_e_be_security.domain.entity.User;
import de.telran.g_10_170123_e_be_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService service;
@GetMapping("/all")
    public List<User> getALL(){
        return service.getALL();
    }

    @GetMapping("/name/{name}")
    public UserDetails getByName(@PathVariable String name){
    return service.loadUserByUsername(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
    service.save(user);

    }

}
