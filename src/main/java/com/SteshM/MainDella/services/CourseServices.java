package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.*;
import com.SteshM.MainDella.Entities.*;
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

    public ResponseDTO createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity =new CourseEntity();
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseDescription(courseDTO.getCourseDescription());

        CourseType courseType = courseTypeRepo.findById(courseDTO.getCourseTypeId()).get();
        courseEntity.setCourseType(courseType);
        CourseEntity createCourse = courseRepo.save(courseEntity);
        return Utilities.createSuccessfulResponse("Successfully created a course", createCourse);

    }


    public ResponseDTO fetchCourseTypes() {
        List<CourseType> courseTypes = courseTypeRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseTypes.forEach(
                courseType -> {
                    CourseTypeDTO courseTypeDTO = new CourseTypeDTO();
                    courseTypeDTO.setCourseTypeId(courseType.getCourseTypeId());
                    courseTypeDTO.setCourseTypename(courseTypeDTO.getCourseTypename());
                    courseDTOList.add(courseTypeDTO);

                }
        );
        log.info("Get {} userTypes",courseDTOList.size());
        return Utilities.createSuccessfulResponse("Successfully fetched coursetypes",courseDTOList);
    }

    }



