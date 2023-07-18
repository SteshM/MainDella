package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topic")
public class TopicsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;
    private String topicName;
//
//    @JsonBackReference
//    @OneToMany
    @JoinColumn(name = "courseId")
    private int courseId;
}