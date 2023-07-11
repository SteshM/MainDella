package com.SteshM.MainDella.DTO;

import lombok.Data;

@Data
public class AnswerDTO {
    private int answerId;
    private Boolean isCorrect;
    private int QuestionId;
}
