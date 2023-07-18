package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepo extends JpaRepository<LessonsEntity, Integer> {
}
