package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.CourseEntity;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.services.CourseServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity,Integer> {


}
