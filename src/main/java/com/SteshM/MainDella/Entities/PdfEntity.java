package com.SteshM.MainDella.Entities;

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
    @JoinColumn(name = "lessonId")
    private int lessonId;
}
