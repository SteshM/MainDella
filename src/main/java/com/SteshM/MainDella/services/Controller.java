package com.SteshM.MainDella.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping(value="hello")
    public String sayHello(){
        return "Hello User";
    }
}
