package com.SteshM.MainDella.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courseLevel")
public class CourseLevel {
    @Id
    private int courseLevelId;
    private String courseLevelName;
    private String courseLevelDescription;

}
