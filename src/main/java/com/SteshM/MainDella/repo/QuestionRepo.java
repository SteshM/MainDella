package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Integer> {
    ArrayList<QuestionEntity> findByTestId(int testId);
}
