package com.SteshM.MainDella.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long profileID;
    @OneToOne
    @JoinColumn(name = "userId")
    private Users user;
    private String username;
    private String password;
    private String role;
}
