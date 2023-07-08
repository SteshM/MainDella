package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepo extends JpaRepository<CourseType ,Integer> {

}
