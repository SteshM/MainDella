package com.SteshM.MainDella.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pdf")
public class PdfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pdfId;
    private String pdfName;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lessonId")
    private LessonsEntity lessonsEntity;
}
