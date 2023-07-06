package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.DTO.UserDTO;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.services.UsersServices;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("v1/getUsertypes")
//    public ResponseDTO getUsertypes(@RequestBody UserDTO)
}
