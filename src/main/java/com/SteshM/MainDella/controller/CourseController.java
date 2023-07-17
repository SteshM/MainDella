package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.*;
import com.SteshM.MainDella.Entities.*;
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
    public ResponseDTO createTest(@RequestBody TestDTO testEntity, @PathVariable int courseID, TestEntity testEntity1 )
    {
        return courseServices.createTest(testEntity,courseID,testEntity1);
    }

    @GetMapping("/course/Test/{courseID}")
    public ResponseDTO getTests(@PathVariable int courseID)
    {
        return courseServices.getTests(courseID);
    }

    @PostMapping("/course/{courseID}/enroll/{userID}")
    public ResponseDTO enroll(@PathVariable Integer courseID, @PathVariable Integer userID)
    {
        return courseServices.enroll(courseID,userID);
    }

//    @GetMapping("/course/enrolled/courseId")
//    public ResponseDTO enrolled(@PathVariable int courseId){
//        return courseServices.enrolled(courseId);
//    }
//

    @PostMapping("/test/{testID}/question")
    public ResponseDTO create(@RequestBody QuestionDTO questionDTO, @PathVariable int testID, QuestionEntity questionEntity)
    {
        return courseServices.create(questionDTO,testID, questionEntity);
    }

    @GetMapping("/test/{testId}/questions")
    public ResponseDTO getQuestions(@PathVariable int testId){
        return courseServices.getQuestions(testId);
    }


    @PostMapping("question/{questionId}/options")
    public  ResponseDTO createOptions(@RequestBody OptionsDTO optionsDTO , @PathVariable int questionId , OptionsEntity optionsEntity)
    {
        return courseServices.createOptions(optionsDTO,questionId , optionsEntity);
    }


    @PostMapping("/question/{questionID}/answer")
    public ResponseDTO createAnswer(@RequestBody AnswerDTO answerDTO, @PathVariable Integer questionID)
    {
        return courseServices.createAnswer(answerDTO,questionID);
    }


}
