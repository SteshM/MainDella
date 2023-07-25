package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentId;
    private String contentUrl;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lessonId")
    private LessonsEntity lessonsEntity;


}
