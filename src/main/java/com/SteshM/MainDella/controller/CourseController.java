package com.SteshM.MainDella.controller;

import com.SteshM.MainDella.DTO.requests.*;
import com.SteshM.MainDella.DTO.response.PathDTO;
import com.SteshM.MainDella.Entities.*;
import com.SteshM.MainDella.services.CourseServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/v1")
public class CourseController {
    @Autowired
    CourseServices courseServices;

    //Creating Paths
    @PostMapping("/path")
    public ResponseDTO createPath(@RequestBody PathDTO path ){
        return courseServices.createPath(path);
    }
    @GetMapping("/paths")
    public ResponseDTO getPaths(){
        return courseServices.getPaths();

    }

    //creating courses
    @PostMapping("/course/create")
    public ResponseDTO createCourse(@RequestBody CourseDTO course){
        return courseServices.createCourse(course);
    }
    @GetMapping("/courses")
    public ResponseDTO getCourses(){
        return courseServices.getCourses();

    }
    @GetMapping("/course/course-level")
    public ResponseDTO getCourseLevel(){
        return courseServices.fetchCourseLevel();
    }

    //Enrolling a user to a course
    @PostMapping("/course/{courseID}/enroll/{userID}")
    public ResponseDTO enroll(@PathVariable Integer courseID, @PathVariable Integer userID)
    {
        return courseServices.enroll(courseID,userID);
    }

    @GetMapping("/course/{courseId}")
    public ResponseDTO getUsersByCourseId(@PathVariable int courseId){
        return courseServices.getEnrolledUsers(courseId);
    }


    //creating topics
    @PostMapping("/course/topic")
    public ResponseDTO createTopic(@RequestBody TopicsDTO topic){
        return courseServices.createTopic(topic);
    }

    @GetMapping("/course/topics")
    public ResponseDTO getTopics(){
        return courseServices.getTopics();
    }


    //creating lessons
    @PostMapping("/course/lesson")
    public ResponseDTO createLesson(@RequestBody LessonsDTO lessonsDTO )
    {
        return courseServices.createLesson(lessonsDTO);
    }

    @GetMapping("/course/lessons")
    public ResponseDTO getLessons(){
        return courseServices.getLessons();

    }

    //content types

    @GetMapping("course/content-types")
    public ResponseDTO getContentTypes(){
        return courseServices.fetchContentTypes();
    }


    //creating a test
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



    @PostMapping("/test/{testID}/question")
    public ResponseDTO create(@RequestBody QuestionDTO questionDTO,@PathVariable int testID)
    {
        return courseServices.create(questionDTO,testID );
    }

    @GetMapping("/test/{testId}/questions")
    public ResponseDTO getQuestions(@PathVariable int testId){
        return courseServices.getQuestions(testId);
    }
}

