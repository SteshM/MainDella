package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.*;
import com.SteshM.MainDella.Entities.CourseEntity;
import com.SteshM.MainDella.Entities.TestEntity;
import com.SteshM.MainDella.Entities.UserCourseMapping;
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
@RequestMapping("/v1")
public class CourseController {
    @Autowired
    CourseServices courseServices;
    @PostMapping("/course/create")
    public ResponseDTO createCourse(@RequestBody CourseDTO course){
        return courseServices.createCourse(course);
    }

    @GetMapping("course/course-types")
    public ResponseDTO getCourseTypes(){
        return courseServices.fetchCourseTypes();
    }

    @GetMapping("/course/course-level")
    public ResponseDTO getCourseLevel(){
        return courseServices.fetchCourseLevel();
    }

    @GetMapping("/courses")
    public ResponseDTO getCourses(){
        return courseServices.getCourses();

    }
    @PostMapping("/course/{courseID}/test")
    public ResponseDTO createTest(@RequestBody TestDTO testEntity, @PathVariable int courseID)
    {
        return courseServices.createTest(testEntity,courseID);
    }

    @GetMapping("/course/Test/{courseID}")
    public ResponseDTO getTests(@PathVariable int courseID)
    {
        return courseServices.getTests(courseID);
    }

    @PostMapping("/course/{courseID}/enroll/{userID}")
    public ResponseDTO enroll(@PathVariable Integer courseID, @PathVariable Integer userID){
        return courseServices.enroll(courseID,userID);
    }
    @PostMapping("/test/{testID}/question")
    public ResponseDTO create(@RequestBody QuestionDTO questionDTO, @PathVariable Integer testID){
        return courseServices.create(questionDTO,testID);
    }
    @PostMapping("/question/{questionID}/answer")
    public ResponseDTO createAnswer(@RequestBody AnswerDTO answerDTO, @PathVariable Integer questionID){
        return courseServices.createAnswer(answerDTO,questionID);
    }


}
