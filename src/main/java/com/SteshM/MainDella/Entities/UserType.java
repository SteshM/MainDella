package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userType")
@Data
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeID;
    private String userTypeName;
}
