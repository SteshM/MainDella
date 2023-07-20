package com.SteshM.MainDella.repo;

import com.SteshM.MainDella.Entities.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTypeRepo extends JpaRepository<ContentType,Integer> {

}
