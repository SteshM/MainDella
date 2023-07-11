package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int questionId;
    private String question;
    @ManyToOne
    @JoinColumn(name = "testId")
    TestEntity testEntity;


}
