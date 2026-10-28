package com.example.demo.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component 
@Data 
public class UserDto {

    private String userName;
    private String userFirstName;
    private String userLastName;
    private String password;
    

}
