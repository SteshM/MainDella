package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUsername(String username);
}
