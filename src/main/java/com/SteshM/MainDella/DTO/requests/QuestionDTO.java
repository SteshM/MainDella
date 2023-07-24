package com.SteshM.MainDella.DTO.requests;

import com.SteshM.MainDella.DTO.requests.AnswerDTO;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class QuestionDTO {
    private String question;
    private List<AnswerDTO> answers ;


}
