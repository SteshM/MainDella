package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int questionId;
    private String question;
    @JoinColumn(name = "testID")
    private int testId;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "answerId")
    private List<AnswersEntity> options= new ArrayList<>();
}
