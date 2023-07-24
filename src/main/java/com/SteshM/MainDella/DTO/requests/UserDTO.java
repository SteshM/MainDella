package com.SteshM.MainDella.DTO.requests;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String dateOfBirth;
//    private  String jobTitle;//
    private int userTypeID;
}
