package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.requests.AuthRequest;
import com.SteshM.MainDella.DTO.requests.ResponseDTO;
import com.SteshM.MainDella.DTO.requests.UserDTO;
import com.SteshM.MainDella.repo.UsersRepo;
import com.SteshM.MainDella.services.UsersServices;
import com.SteshM.MainDella.utilities.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    UsersServices usersServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/hello")
    public String welcome() {
        return "Hello enjoy our Services! ";
    }


    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    //Register a User
    @PostMapping("/register")
    public ResponseDTO register(@RequestBody UserDTO user){
        log.info("Received a request to register a user. Payload received:{}",user);
        return usersServices.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),authRequest.getPassword()
        ));
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid access");
        }
    }
    //Fetch UserTypes

    @GetMapping("/user-types")
    public ResponseDTO getUsertypes(){
        return usersServices.fetchUserTypes();
    }


    @GetMapping("/fetchUsers")
    public ResponseDTO fetchUsers(){
        return usersServices.fetchAll();

    }



}
