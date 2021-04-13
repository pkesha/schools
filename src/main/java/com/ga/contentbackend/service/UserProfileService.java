package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationExistsException;
import com.ga.contentbackend.model.UserProfile;
import com.ga.contentbackend.repository.UserProfileRepository;
import com.ga.contentbackend.repository.UserRepository;
import com.ga.contentbackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserProfileRepository userProfileRepository;
    private UserRepository userRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    public UserProfile createUserProfile(UserProfile userProfile){

        MyUserDetails myUserDetails =
                (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(myUserDetails.getUser().getId());
        userProfile.setUser(myUserDetails.getUser());
        UserProfile foundUserProfile =
                userProfileRepository.findByFirstNameAndLastName(userProfile.getFirstName(), userProfile.getLastName());

        if(foundUserProfile != null){
            throw new InformationExistsException("This User Profile exists!");
        }else{
            return userProfileRepository.save(userProfile);
        }
    }
}
