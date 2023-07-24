package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int lessonId;
    private String lessonName;

    private String content;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "topicId")
    private TopicsEntity topics;

    @JoinColumn(name = "contentTypeId")
    private int contentTypeId;
}
