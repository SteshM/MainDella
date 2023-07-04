package com.SteshM.MainDella.services;

import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping(value="hello")
    public String sayHello(){
        return "Hello User";
    }
    @Autowired
    UsersServices usersServices;
    @PostMapping("register/{who}")
    public Users register(Users user, HttpServletResponse response, @PathVariable("who")UserType userType){
        return usersServices.register(user,response, userType);
    }
}
