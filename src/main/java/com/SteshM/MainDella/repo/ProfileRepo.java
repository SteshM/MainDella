package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    Profile findByUsername(String email);
}
