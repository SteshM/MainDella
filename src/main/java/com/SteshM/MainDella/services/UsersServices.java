package com.SteshM.MainDella.services;

import com.SteshM.MainDella.DTO.requests.AuthRequest;
import com.SteshM.MainDella.DTO.requests.ResponseDTO;
import com.SteshM.MainDella.DTO.requests.UserDTO;
import com.SteshM.MainDella.DTO.requests.UserTypeDTO;
import com.SteshM.MainDella.Entities.Profile;
import com.SteshM.MainDella.Entities.UserType;
import com.SteshM.MainDella.Entities.Users;
import com.SteshM.MainDella.repo.ProfileRepo;
import com.SteshM.MainDella.repo.UsersRepo;
import com.SteshM.MainDella.repo.UserTypeRepo;
import com.SteshM.MainDella.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServices implements UserDetailsService {
    private final UsersRepo usersRepo;
    private final UserTypeRepo userTypeRepo;
    private final ProfileRepo profileRepo;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Profile> profile = profileRepo.findByUsername(username);
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(profile.get().getRole()));
    return new User(profile.get().getUsername(), profile.get().getPassword(),authorities);
}
@Autowired
PasswordEncoder encoder;
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
        profile.setRole(userType.getUserTypeName());
        profile.setUsername(userDTO.getEmail());
        profile.setPassword(encoder.encode(userDTO.getPassword()));
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


    public ResponseDTO login(AuthRequest authRequest) {
        String username = authRequest.getUsername();
       Optional<Profile>  profile = profileRepo.findByUsername(username);
        log.info("fetched a profile by username{}", profile);
        if (authRequest.getPassword().equals(profile.get().getPassword())) {
            log.info("logged i successfully");
            return Utilities.createSuccessfulResponse("logged in", Collections.emptyList());
        } else {
            log.info("The provided password did ot match");
            return Utilities.createFailedResponse(401, "Password mismatch");
        }

    }


    public ResponseDTO fetchAll() {
        ArrayList<Users>users = (ArrayList<Users>) usersRepo.findAll();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatusCode( 200);
        responseDTO.setStatusDescription("Ok");
        responseDTO.setData(users);
        return responseDTO;
    }
}

