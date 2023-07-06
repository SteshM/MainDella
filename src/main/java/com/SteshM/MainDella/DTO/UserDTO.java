package com.SteshM.MainDella.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String dateOfBirth;
    private int userTypeID;
}
