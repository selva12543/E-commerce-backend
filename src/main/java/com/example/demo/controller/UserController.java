package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController 
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/createuser")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    
    // register user from form
    @PostMapping("/registeruser")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        userService.registerUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("user was created");
    }

}
