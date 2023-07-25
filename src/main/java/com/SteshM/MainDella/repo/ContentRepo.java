package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepo extends JpaRepository<ContentEntity,Integer> {
}
