package com.SteshM.MainDella.Entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
public class TestEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;
    private String testName;
    @OneToMany
    @JoinColumn(name = "testId")
    private List<QuestionEntity> questionEntities;
    @JoinColumn(name = "courseId")
    private int courseID;

}
