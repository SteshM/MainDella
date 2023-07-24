package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "path")
public class PathEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pathId;
    private String pathName;
    private  String description;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "courseId")
    private List<CourseEntity> courses= new ArrayList<>();

}
