package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.DTO.UserDTO;
import com.SteshM.MainDella.Entities.Profile;
import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.repo.ProfileRepo;
import com.SteshM.MainDella.repo.UsersRepo;
import com.SteshM.MainDella.repo.UserTypeRepo;
import com.SteshM.MainDella.utilities.Utilities;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServices {
    private final UsersRepo usersRepo;
    private final UserTypeRepo userTypeRepo;
    private final ProfileRepo profileRepo;

    public ResponseDTO register(UserDTO userDTO){
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());

        UserType userType = userTypeRepo.findById(userDTO.getUserTypeID()).get();
        user.setUserType(userType);

        Users createdUser = usersRepo.save(user);

        Profile profile = new Profile();
        profile.setUser(createdUser);
        profile.setUsername(userDTO.getEmail());
        profile.setPassword(userDTO.getPassword());
        Profile createdProfile = profileRepo.save(profile);

        return Utilities.createSuccessfulResponse("Successfully created a user", createdProfile);
    }


}
