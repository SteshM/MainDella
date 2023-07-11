package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answers")
public class AnswersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "questionId")
    private QuestionEntity questionEntity;

}
