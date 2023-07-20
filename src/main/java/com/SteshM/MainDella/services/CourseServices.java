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
    private final PathRepo pathRepo;
    private final TopicsRepo topicsRepo;
    private final LessonsRepo lessonsRepo;
    private final  VideoRepo videoRepo;
    private final PdfRepo pdfRepo;

//Creating a Path

public ResponseDTO createPath(PathDTO path) {
    PathEntity pathEntity =new PathEntity();
    pathEntity.setPathName(path.getPathName());
    pathEntity.setDescription(path.getDescription());
    PathEntity createPath = pathRepo.save(pathEntity);
    return Utilities.createSuccessfulResponse("Successfully created a Path" , createPath);
}

//Fetching Paths
public ResponseDTO getPaths() {
    List<PathEntity> paths = pathRepo.findAll();
    return Utilities.createSuccessfulResponse("Successfully fetched all paths", paths);

}

//Creating a course
    public ResponseDTO createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseDescription(courseDTO.getCourseDescription());
        CourseLevel courseLevel = courseLevelRepo.findById(courseDTO.getCourseLevelId()).get();
        courseEntity.setCourseLevel(courseLevel);
        PathEntity path = pathRepo.findById(courseDTO.getPathId()).get();
        courseEntity.setPath(path);
        CourseEntity createCourse = courseRepo.save(courseEntity);
        return Utilities.createSuccessfulResponse("Successfully created a course", createCourse);

    }


//List all courses
    public ResponseDTO getCourses() {
        List<CourseEntity> courses = courseRepo.findAll();
        return Utilities.createSuccessfulResponse("Successfully fetched Courses", courses);
    }

    //Creating Topics
    public ResponseDTO createTopic(TopicsDTO topic) {
    TopicsEntity topicsEntity = new TopicsEntity();
    topicsEntity.setTopicName(topic.getTopicName());
    CourseEntity courseEntity = courseRepo.findById(topic.getCourseId()).get();
    topicsEntity.setCourseEntity(courseEntity);
    topicsRepo.save(topicsEntity);
    return Utilities.createSuccessfulResponse("Successfully created a topic", topic);


    }
//List topics

    public ResponseDTO getTopics() {
        List<TopicsEntity>topics = topicsRepo.findAll();
        return Utilities.createSuccessfulResponse("Successfully fetched topics",topics);
    }

    //Create Lessons
    public ResponseDTO createLesson(LessonsDTO lessonsDTO) {
    LessonsEntity lessonsEntity = new LessonsEntity();
    lessonsEntity.setLessonName(lessonsDTO.getLessonName());
    TopicsEntity topicsEntity = topicsRepo.findById(lessonsDTO.getTopicId()).get();
    lessonsEntity.setTopics(topicsEntity);
    lessonsRepo.save(lessonsEntity);
    return Utilities.createSuccessfulResponse("Successfully created a Lesson" , lessonsDTO);
    }




//List all courses
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


//List courseLevel
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


//Creating a Test
    public ResponseDTO createTest(TestDTO testDTO, Integer courseID,TestEntity testEntity) {
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setTestName(testDTO.getTestName());
        testEntity1.setCourseID(courseID);
        testRepo.save(testEntity1);
        return Utilities.createSuccessfulResponse("Successfully created a test", testDTO);
    }


    //Retrieving Tests
    public ResponseDTO getTests(int CourseID){
        ArrayList<TestEntity> testEntities = testRepo.findByCourseID(CourseID);
        return Utilities.createSuccessfulResponse("success", testEntities);
    }


//Enrolling into a course
    public ResponseDTO enroll(Integer courseID, Integer userID) {
        CourseEntity courseEntity = courseRepo.findById(courseID).get();
        Users users = usersRepo.findById(userID).get();
        UserCourseMapping userCourseMapping = new UserCourseMapping();
        userCourseMapping.setCourseId(courseEntity.getCourseId());
        userCourseMapping.setUserId(users.getUserId());
        UserCourseMapping createdEnrollment = userCourseMappingRepo.save(userCourseMapping);
        return Utilities.createSuccessfulResponse("successfully enrolled to a course" ,createdEnrollment);
    }


//Creating a Question
    public ResponseDTO create(QuestionDTO questionDTO, Integer testID, QuestionEntity questionEntity1) {
        questionEntity1.setTestId(testID);
        questionEntity1.setQuestion(questionDTO.getQuestion());
        QuestionEntity createQuestion = questionRepo.save(questionEntity1);

        questionDTO.getAnswers().forEach(
                answerDTO -> {
                    AnswersEntity answersEntity = new AnswersEntity();
                    answersEntity.setQuestionEntity(createQuestion);
                    answersEntity.setAnswer(answerDTO.getAnswer());
                    answersEntity.setIsCorrect(answerDTO.isCorrect());
                    answerRepo.save(answersEntity);
                }
        );
        return Utilities.createSuccessfulResponse("Successfully created a question",createQuestion);
    }


    //Retrieving Questions
    public ResponseDTO getQuestions(int testId) {
        ArrayList<QuestionEntity>questionEntities = questionRepo.findByTestId(testId);
        return Utilities.createSuccessfulResponse("successfully fetched all questions" , questionEntities);


    }

//    public ResponseDTO getEnrolledUsers(String courseName) {
////       ArrayList<UserCourseMapping>  userCourseMappings = userCourseMappingRepo.findByCourseName(courseName);
//       ArrayList<String> usernames = new ArrayList<>();
//       for(UserCourseMapping userCourseMapping: userCourseMapping){
//           Users user = usersRepo.findById(userCourseMapping.getUserId()).get();
//           usernames.add(user.getName());
//       }
//        return Utilities.createSuccessfulResponse("successfully fetched enrolled Users" , usernames);
//
//    }


    public ResponseDTO getLessons()
            {
    List<LessonsEntity>lessonsEntities = lessonsRepo.findAll();
    return Utilities.createSuccessfulResponse("Successfully fetched lessons", lessonsEntities);
    }

    public ResponseDTO createVideo(VideoDTO videoDTO) {
    VideoEntity videoEntity = new VideoEntity();
    videoEntity.setVideoName(videoDTO.getVideoName());
    videoEntity.setDuration(videoDTO.getDuration());
    LessonsEntity lessonsEntity = lessonsRepo.findById(videoDTO.getLessonId()).get();
    videoEntity.setLessonsEntity(lessonsEntity);
    videoRepo.save(videoEntity);
    return Utilities.createSuccessfulResponse("Successfully created a video",videoEntity);
    }

    public ResponseDTO getVideos() {
    List<VideoEntity>videoEntities = videoRepo.findAll();
    return Utilities.createSuccessfulResponse("Successfully fetched all videos" , videoEntities);
    }

    public ResponseDTO createPdf(PdfDTO pdfDTO) {
    PdfEntity pdfEntity = new PdfEntity();
    pdfEntity.setPdfName(pdfDTO.getPdfName());
    LessonsEntity lessonsEntity = lessonsRepo.findById(pdfDTO.getLessonId()).get();
    pdfEntity.setLessonsEntity(lessonsEntity);
    pdfRepo.save(pdfEntity);
    return Utilities.createSuccessfulResponse("Successfully created a Pdf",pdfEntity);
    }

    public ResponseDTO getPdfs() {
    List<PdfEntity>pdfEntities = pdfRepo.findAll();
    return Utilities.createSuccessfulResponse("Successfully fetched Pdfs",pdfEntities);
    }

    public ResponseDTO getEnrolledUsers(int courseId) {
        List<UserCourseMapping>  userCourseMappings = userCourseMappingRepo.findByCourseId(courseId);
        List<String>usernames = new ArrayList<>();
       for(UserCourseMapping userCourseMapping:userCourseMappings){
           Users user = usersRepo.findById(userCourseMapping.getUserId()).get();
           usernames.add(user.getName());
       }
        return Utilities.createSuccessfulResponse("successfully fetched enrolled Users" , usernames);
    }
}


