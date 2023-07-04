package com.SteshM.MainDella.services;

import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @RequestMapping(value="hello")
    public String sayHello(){
        return "Hello User";
    }
    @Autowired
    UsersServices usersServices;
    @PostMapping("register/{who}")
    public Users register(@RequestBody  Users user, HttpServletResponse response, @PathVariable("who")String userType){
        UserType userType1 = UserType.valueOf(userType);

        return usersServices.register(user,response, userType1);
    }
}
