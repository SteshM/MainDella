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

    @PostMapping("/path")
    public ResponseDTO createPath(@RequestBody PathDTO path ){
        return courseServices.createPath(path);
    }
    @GetMapping("/paths")
    public ResponseDTO getPaths(){
        return courseServices.getPaths();

    }
    @PostMapping("/course/create")
    public ResponseDTO createCourse(@RequestBody CourseDTO course){
        return courseServices.createCourse(course);
    }
    @GetMapping("/courses")
    public ResponseDTO getCourses(){
        return courseServices.getCourses();

    }
    @PostMapping("/course/topic")
    public ResponseDTO createTopic(@RequestBody TopicsDTO topic){
        return courseServices.createTopic(topic);
    }

    @GetMapping("/course/topics")
    public ResponseDTO getTopics(){
        return courseServices.getTopics();
    }

    @PostMapping("/course/lesson")
    public ResponseDTO createLesson(@RequestBody  LessonsDTO lessonsDTO )
    {
        return courseServices.createLesson(lessonsDTO);
    }

    @GetMapping("/course/lessons")
    public ResponseDTO getLessons(){
        return courseServices.getLessons();

    }


    @GetMapping("course/course-types")
    public ResponseDTO getCourseTypes(){
        return courseServices.fetchCourseTypes();
    }

    @GetMapping("/course/course-level")
    public ResponseDTO getCourseLevel(){
        return courseServices.fetchCourseLevel();
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

    @GetMapping("/{courseName}")
    public ResponseDTO getUsersByCourse(@PathVariable String courseName){
        return courseServices.getEnrolledUsers(courseName);
    }

    @PostMapping("/test/{testID}/question")
    public ResponseDTO create(@RequestBody QuestionDTO questionDTO,@PathVariable int testID, QuestionEntity questionEntity)
    {
        return courseServices.create(questionDTO,testID, questionEntity);
    }

    @GetMapping("/test/{testId}/questions")
    public ResponseDTO getQuestions(@PathVariable int testId){
        return courseServices.getQuestions(testId);
    }

    @PostMapping("/video")
    public ResponseDTO createVideo(@RequestBody VideoDTO videoDTO){
        return courseServices.createVideo(videoDTO);
}

@GetMapping("/videos")
public ResponseDTO getVideos(){
        return  courseServices.getVideos();
}

@PostMapping("/pdf")
    public ResponseDTO createPdf(PdfDTO pdfDTO){
        return courseServices.createPdf(pdfDTO);
}

@GetMapping("/pdfs")
    public ResponseDTO getPdfs(){
        return courseServices.getPdfs();
}

}
