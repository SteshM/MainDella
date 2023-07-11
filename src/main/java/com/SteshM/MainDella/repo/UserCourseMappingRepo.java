package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.UserCourseMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseMappingRepo extends JpaRepository<UserCourseMapping,Integer> {
}
