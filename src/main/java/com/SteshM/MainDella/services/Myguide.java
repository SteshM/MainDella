package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.requests.*;
import com.SteshM.MainDella.DTO.response.PathDTO;
import com.SteshM.MainDella.Entities.LessonsEntity;
import com.SteshM.MainDella.Entities.PathEntity;
import com.SteshM.MainDella.Entities.PdfEntity;
import com.SteshM.MainDella.Entities.TopicsEntity;

import java.util.ArrayList;

public interface Myguide {
    public abstract ResponseDTO addPath(PathDTO dto);
    public ArrayList<PathEntity> getpaths();

    public abstract ResponseDTO addTopic(TopicsDTO topic);
    public ArrayList<TopicsEntity>getCourseTopics(int CourseId);

    public abstract ResponseDTO addLesson(LessonsDTO dto);
    public ArrayList<LessonsEntity>getTopicLessons(int topicId);

    public abstract ResponseDTO addVideo(VideoDTO dto);
    public ArrayList<VideoDTO>getLessonVideos(int lessonId);

    public abstract ResponseDTO addPdf(PathDTO dto);
    public ArrayList<PdfEntity>getLessonPdf(int lessonId);

}
