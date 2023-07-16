package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TestRepo extends JpaRepository<TestEntity,Integer> {
public ArrayList<TestEntity> findByCourseID(int courseId);
}
