package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoId;
    private String videoName;
    private String duration;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "lessonId")
    private LessonsEntity lessonsEntity;
}
