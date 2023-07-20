package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contentType")
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentTypeId;
    private String contentTypeName;
}
