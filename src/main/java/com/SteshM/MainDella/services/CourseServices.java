package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.*;
import com.SteshM.MainDella.Entities.*;
import com.SteshM.MainDella.repo.*;
import com.SteshM.MainDella.utilities.Utilities;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Data

public class CourseServices {
     private final UserCourseMappingRepo userCourseMappingRepo;
    private final CourseRepo courseRepo;
    private final CourseTypeRepo courseTypeRepo;
    private final CourseLevelRepo courseLevelRepo;
    private final TestRepo testRepo;
    private final UsersRepo usersRepo;
    private final QuestionRepo questionRepo;
    private final AnswerRepo answerRepo;


    public ResponseDTO createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseDescription(courseDTO.getCourseDescription());
        CourseLevel courseLevel = courseLevelRepo.findById(courseDTO.getCourseLevelId()).get();
        courseEntity.setCourseLevel(courseLevel);
        CourseType courseType = courseTypeRepo.findById(courseDTO.getCourseTypeId()).get();
        courseEntity.setCourseType(courseType);
        CourseEntity createCourse = courseRepo.save(courseEntity);
        return Utilities.createSuccessfulResponse("Successfully created a course", createCourse);

    }

    public ResponseDTO getCourses() {
        List<CourseEntity> courses = courseRepo.findAll();

        return Utilities.createSuccessfulResponse("Successfully fetched Courses", courses);
    }


    public ResponseDTO fetchCourseTypes() {
        List<CourseType> courseTypes = courseTypeRepo.findAll();
        List<CourseType> courseDTOList = new ArrayList<>();
        courseTypes.forEach(
                courseType -> {
                    CourseType courseTypeDTO = new CourseType();
                    courseTypeDTO.setCourseTypeId(courseType.getCourseTypeId());
                    courseTypeDTO.setCourseTypeName(courseType.getCourseTypeName());
                    courseDTOList.add(courseTypeDTO);
                }
        );
        log.info("Get {} userTypes", courseDTOList.size());
        return Utilities.createSuccessfulResponse("Successfully fetched courseTypes", courseDTOList);
    }

    public ResponseDTO fetchCourseLevel() {
        List<CourseLevel> courseLevels = courseLevelRepo.findAll();
        List<CourseLevel> courseDTOList = new ArrayList<>();
        courseLevels.forEach(
                courseLevel -> {
                    CourseLevel courseLevel1DTO = new CourseLevel();
                    courseLevel1DTO.setCourseLevelId(courseLevel.getCourseLevelId());
                    courseLevel1DTO.setCourseLevelName(courseLevel.getCourseLevelName());
                    courseLevel1DTO.setCourseLevelDescription(courseLevel.getCourseLevelDescription());
                    courseDTOList.add(courseLevel1DTO);
                }
        );
        log.info("Get {} CourseLevel", courseDTOList.size());
        return Utilities.createSuccessfulResponse("Successfully fetched courseLevels;", courseDTOList);
    }


    public ResponseDTO createTest(TestDTO testDTO, Integer courseID) {
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setTestName(testDTO.getTestName());
        testEntity1.setCourseEntity(courseRepo.findById(courseID).get());
        TestEntity testEntity= testRepo.save(testEntity1);
        return Utilities.createSuccessfulResponse("Successfully created a test", testEntity);
    }


    public ResponseDTO enroll(Integer courseID, Integer userID) {
        CourseEntity courseEntity = courseRepo.findById(courseID).get();
        Users users = usersRepo.findById(userID).get();
        UserCourseMapping userCourseMapping = new UserCourseMapping();
        userCourseMapping.setCourseEntity(courseEntity);
        userCourseMapping.setUser(users);
        UserCourseMapping createdEnrollment = userCourseMappingRepo.save(userCourseMapping);
        return Utilities.createSuccessfulResponse("successfully enrolled to a course" ,createdEnrollment);
    }

    public ResponseDTO create(QuestionDTO questionDTO, Integer testID) {
        QuestionEntity questionEntity = new QuestionEntity();
        TestEntity testEntity = testRepo.findById(testID).get();
        questionEntity.setTestEntity(testEntity);
        questionEntity.setQuestion(questionDTO.getQuestion());
        QuestionEntity createQuestion = questionRepo.save(questionEntity);
        return Utilities.createSuccessfulResponse("Successfully created a question",createQuestion);
    }


    public ResponseDTO createAnswer(AnswerDTO answerDTO, Integer questionID) {
        AnswersEntity answersEntity = new AnswersEntity();
        QuestionEntity questionEntity  = questionRepo.findById(questionID).get();
        answersEntity.setQuestionEntity(questionEntity);
        answersEntity.setCorrect(answerDTO.getIsCorrect());
        AnswersEntity createAnswer = answerRepo.save(answersEntity);
        return Utilities.createSuccessfulResponse("successfully created correct answer",createAnswer );
    }
}



