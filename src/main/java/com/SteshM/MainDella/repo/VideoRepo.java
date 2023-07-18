package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo  extends JpaRepository<VideoEntity ,Integer> {
}
