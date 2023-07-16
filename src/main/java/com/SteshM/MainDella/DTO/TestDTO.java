package com.SteshM.MainDella.DTO;

import com.SteshM.MainDella.Entities.QuestionEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TestDTO {
    private String testName;
    private QuestionEntity question;
}
