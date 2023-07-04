package com.SteshM.MainDella.services;

import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.repo.UsersRepo;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsersServices {
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
    public Users register(Users user, HttpServletResponse response){
        if(usersRepo.findByEmail(user.getEmail())!= null){
            this.alreadyExists(response);
            return null;
        }else{
            usersRepo.save(user);
            return user;
        }
    }
}
