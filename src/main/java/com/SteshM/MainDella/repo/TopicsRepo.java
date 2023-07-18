package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.TopicsEntity;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepo extends JpaRepository<TopicsEntity,Integer> {
}
