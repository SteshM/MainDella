package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
