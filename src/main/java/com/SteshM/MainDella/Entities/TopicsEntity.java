package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topics")
public class TopicsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;
    private String topicName;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "lessonId")
    private List<LessonsEntity> lessons= new ArrayList<>();

}
