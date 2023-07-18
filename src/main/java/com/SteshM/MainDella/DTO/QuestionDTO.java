package com.SteshM.MainDella.DTO;

import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.Collection;
import java.util.List;

@Data
public class QuestionDTO {
    private String question;
    private Collection<AnswerDTO> answers ;


}
