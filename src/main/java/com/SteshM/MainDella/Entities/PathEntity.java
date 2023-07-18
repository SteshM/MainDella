package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "path")
public class PathEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pathId;
    private String pathName;
    private  String description;


}
