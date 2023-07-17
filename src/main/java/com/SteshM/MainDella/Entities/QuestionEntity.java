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
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int questionId;
    private String question;
    @JoinColumn(name = "testID")
    private int testId;
    @ManyToMany
    @JoinColumn(name = "optionId")
    private Collection<OptionsEntity> options = new ArrayList<>();

}
