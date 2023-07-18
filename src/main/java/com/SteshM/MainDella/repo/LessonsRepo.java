package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonsRepo extends JpaRepository<LessonsEntity, Integer> {
   
}
