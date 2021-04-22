package com.dm.demojpa.controllers;

import com.dm.demojpa.model.Users;
import com.dm.demojpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hellodisp(){
        return "hello testing ";
    }
    @GetMapping("/users")
    public List<Users> usersList(){
        return userService.findAll();
    }
    @GetMapping("/users/{name}")
    public Users findByname(@PathVariable final String name){
        return userService.findByname(name);
    }
    @PostMapping("/users/save")
    public Users saveUsers(@RequestBody Users users){
        Users users1=userService.saveUsers(users);
        return users1;
    }
}
