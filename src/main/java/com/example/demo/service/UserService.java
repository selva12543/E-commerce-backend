package com.example.demo.service;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.Rolerepository;
import com.example.demo.repository.UserRepo;

import jakarta.transaction.Transactional;

import java.util.Set;

@Service 
public class UserService {

    private UserRepo userRepository;
    private Rolerepository roleRepository;

    UserService(UserRepo userRepository , Rolerepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // save user
    public User saveUser(User user){
        return userRepository.save(user);
    }


    @Transactional 
    public void registerUser(UserDto userDto) {

        Role userRole = roleRepository.findByRoleName("USER")
                        .orElseThrow( () -> new RuntimeException("user role not found") );

        User user = new User();

        user.setUserName(userDto.getUserName());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setPassword(userDto.getPassword());
        user.setRoles(Set.of(userRole));

        // save user with role
        userRepository.save(user);
        
    }

}
