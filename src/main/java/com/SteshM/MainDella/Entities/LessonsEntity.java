package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int lessonId;
    private String lessonName;

    @JoinColumn(name = "topicId")
    private int topicId;

}