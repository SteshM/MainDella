package com.SteshM.MainDella.DTO.requests;

import com.SteshM.MainDella.DTO.requests.CourseDTO;
import lombok.Data;

@Data
public class CourseLevelDTO extends CourseDTO {

    private int courseLevelId;
    private String courseLevelName;
    private String courseDescription;
}
