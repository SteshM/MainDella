package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "courseType")
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseTypeId;
    private String courseTypeName;
}
