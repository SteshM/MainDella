package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<AnswersEntity,Integer> {
}
