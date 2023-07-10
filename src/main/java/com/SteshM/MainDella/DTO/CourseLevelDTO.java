package com.SteshM.MainDella.DTO;

import lombok.Data;

@Data
public class CourseLevelDTO extends CourseDTO {

    private int courseLevelId;
    private String courseLevelName;
    private String courseDescription;
}
