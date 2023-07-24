package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="pathId")
    private PathEntity path;
    @ManyToOne
    @JoinColumn(name = "courselevelId")
    private CourseLevel courseLevel;
    private String courseDescription;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "topicId")
    private List<TopicsEntity> topics= new ArrayList<>();


}
