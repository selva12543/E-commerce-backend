package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController 
public class RoleController {

    private final RoleService roleService;

    RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    // save role
    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role role){
        
        return roleService.saveRole(role);
    }

}
