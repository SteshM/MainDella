package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseLevelRepo extends JpaRepository<CourseLevel,Integer > {

}
