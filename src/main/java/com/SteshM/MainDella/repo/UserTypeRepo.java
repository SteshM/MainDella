package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserTypeRepo extends JpaRepository<UserType, Integer> {
}
