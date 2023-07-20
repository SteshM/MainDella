package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.UserCourseMapping;
import com.SteshM.MainDella.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserCourseMappingRepo extends JpaRepository<UserCourseMapping,Integer> {

    List<UserCourseMapping> findByCourseId(int courseId);
}
