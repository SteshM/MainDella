package com.SteshM.MainDella.Entities;

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
    private int duration;

    @JoinColumn(name = "lessonId")
    private int lessonId;
}
