package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.Rolerepository;

@Service 
public class RoleService {

    private final Rolerepository roleRepository;

    RoleService(Rolerepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

}
