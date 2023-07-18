package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.PathDTO;
import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.DTO.TopicsDTO;
import com.SteshM.MainDella.Entities.PathEntity;
import com.SteshM.MainDella.Entities.TopicsEntity;
import com.SteshM.MainDella.repo.TopicsRepo;

import java.util.ArrayList;

public interface Myguide {
    public abstract ResponseDTO addPath(PathDTO dto);
    public ArrayList<PathEntity> getpaths();

    public abstract ResponseDTO addTopic(TopicsDTO topic);
    public ArrayList<TopicsEntity>getC
}
