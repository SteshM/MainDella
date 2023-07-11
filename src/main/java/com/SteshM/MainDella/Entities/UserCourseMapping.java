package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="userCourseMapping")
public class UserCourseMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCourseMappingId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;


}
