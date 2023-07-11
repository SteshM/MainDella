package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<TestEntity,Integer> {
}
