package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.CourseDTO;
import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.services.CourseServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/courses")
public class CourseController {
    @Autowired
    CourseServices courseServices;
    @PostMapping("/createCourse")
    public ResponseDTO createCourse(@RequestBody CourseDTO course){
        return courseServices.createCourse(course);
    }

    @GetMapping("/getCourseTypes")
    public ResponseDTO getCourseTypes(){
        return courseServices.fetchCourseTypes();
    }
}
