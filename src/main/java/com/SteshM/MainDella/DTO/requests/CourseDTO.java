package com.SteshM.MainDella.DTO.requests;

import lombok.Data;

@Data
public class CourseDTO {
    private String courseName;
    private String courseDescription;
    private int pathId;
    private int courseLevelId;
    private int topicId;

}
