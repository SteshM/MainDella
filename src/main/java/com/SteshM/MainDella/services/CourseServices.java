package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.*;
import com.SteshM.MainDella.Entities.*;
import com.SteshM.MainDella.repo.CourseLevelRepo;
import com.SteshM.MainDella.repo.CourseRepo;
import com.SteshM.MainDella.repo.CourseTypeRepo;
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
    private final CourseRepo courseRepo;
    private final CourseTypeRepo courseTypeRepo;
    private final CourseLevelRepo courseLevelRepo;


    public ResponseDTO createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity =new CourseEntity();
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseDescription(courseDTO.getCourseDescription());
        CourseLevel courseLevel = courseLevelRepo.findById(courseDTO.getCourseLevelId()).get();
        courseEntity.setCourseLevel(courseLevel);
        CourseType courseType = courseTypeRepo.findById(courseDTO.getCourseTypeId()).get();
        courseEntity.setCourseType(courseType);
        CourseEntity createCourse = courseRepo.save(courseEntity);
        return Utilities.createSuccessfulResponse("Successfully created a course", createCourse);

    }

    public ResponseDTO  getCourses() {
     CourseEntity courseDTO= new CourseEntity();
     courseDTO.setCourseName(courseDTO.getCourseName());
     courseDTO.setCourseLevel(courseDTO.getCourseLevel());
     courseDTO.setCourseDescription(courseDTO.getCourseDescription());
     courseDTO.setCourseType(courseDTO.getCourseType());
     return Utilities.createSuccessfulResponse("Successfully fetched Courses" , courseDTO);
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
        log.info("Get {} userTypes",courseDTOList.size());
        return Utilities.createSuccessfulResponse("Successfully fetched courseTypes",courseDTOList);
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
        log.info("Get {} CourseLevel",courseDTOList.size());
        return Utilities.createSuccessfulResponse("Successfully fetched courseLevels;",courseDTOList);
    }

}



