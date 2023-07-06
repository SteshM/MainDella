package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.ResponseDTO;
import com.SteshM.MainDella.DTO.UserDTO;
import com.SteshM.MainDella.DTO.UserTypeDTO;
import com.SteshM.MainDella.Entities.Profile;
import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.repo.ProfileRepo;
import com.SteshM.MainDella.repo.UsersRepo;
import com.SteshM.MainDella.repo.UserTypeRepo;
import com.SteshM.MainDella.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.*;

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


    public ResponseDTO fetchUserTypes() {
        List<UserType> userTypes = userTypeRepo.findAll();
        List<UserTypeDTO> userTypeDTOList = new ArrayList<>();

        userTypes.forEach(
                userType -> {
                    UserTypeDTO userTypeDTO = new UserTypeDTO();
                    userTypeDTO.setUserTypeID(userType.getUserTypeID());
                    userTypeDTO.setUserTypeName(userType.getUserTypeName());
                    userTypeDTOList.add(userTypeDTO);
                }
        );
        log.info("Get {} user types", userTypeDTOList.size());

        return Utilities.createSuccessfulResponse("Successfully fetched user types", userTypeDTOList) ;
    }
}
