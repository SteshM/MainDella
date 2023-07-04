package com.SteshM.MainDella.services;

import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.repo.UsersRepo;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsersServices implements UserDetailsService {
    private final PasswordEncoder encoder;
    JsonMapper jsonMapper = new JsonMapper();
    Map<String, String> map;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public void notFound(HttpServletResponse response, String message){
        response.setContentType("application/json");
        map = new HashMap<>();
        map.put("response","fail");
        map.put("message", message+" not found");
        try{
            jsonMapper.writeValue(response.getOutputStream(), map);
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
    }
    public Users getUser(String email){
        return usersRepo.findByEmail(email);
    }
    public void alreadyExists(HttpServletResponse response){
        response.setContentType("application/json");
        map = new HashMap<>();
        map.put("response","fail");
        map.put("message", "already exists");
        try{
            jsonMapper.writeValue(response.getOutputStream(), map);
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
    }
    public void success(HttpServletResponse response){
        response.setContentType("application/json");
        map = new HashMap<>();
        map.put("response","success");
        map.put("message", "completed task");
        try{
            jsonMapper.writeValue(response.getOutputStream(), map);
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
    }
    @Autowired
    UsersRepo usersRepo;
    public Users register(Users user, HttpServletResponse response, UserType userType){
        if(usersRepo.findByEmail(user.getEmail())!= null){
            this.alreadyExists(response);
            return null;
        }else{
            user.setUserType(userType);
            user.setPassword(encoder.encode(user.getPassword()));
            usersRepo.save(user);
            return user;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user1 = this.getUser(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(user1.getUserType())));
        return new User(user1.getEmail(), user1.getPassword(), authorities);
    }
}
