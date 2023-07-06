package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.DTO.UserDTO;
import com.SteshM.MainDella.DTO.UserTypeDTO;
import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.services.UsersServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UsersServices usersServices;
    @PostMapping("/register")
    public ResponseDTO register(@RequestBody UserDTO user){
        log.info("Received a request to register a user. Payload received:{}",user);
        return usersServices.register(user);
    }
    @GetMapping("/user-types")
    public ResponseDTO getUsertypes(){
        return usersServices.fetchUserTypes();
    }

}
