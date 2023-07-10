package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.CourseDTO;
import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.Entities.CourseEntity;
import com.SteshM.MainDella.services.CourseServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@NoArgsConstructor
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

    @GetMapping("/courselevel")
    public ResponseDTO getCourseLevel(){
        return courseServices.fetchCourseLevel();
    }

    @GetMapping("/courses")
    public ResponseDTO getCourses(){
        return courseServices.getCourses();

    }




}
