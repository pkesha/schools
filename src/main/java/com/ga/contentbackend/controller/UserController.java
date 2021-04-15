package com.ga.contentbackend.controller;

import com.ga.contentbackend.model.Request.LoginRequest;
import com.ga.contentbackend.model.User;
import com.ga.contentbackend.model.UserProfile;
import com.ga.contentbackend.service.UserProfileService;
import com.ga.contentbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    private final UserService userService;
    private final UserProfileService userProfileService;

    public UserController(UserService userService,
                          UserProfileService userProfileService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User userObject) {
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("calling loginUser ==>");
        return userService.loginUser(loginRequest);
    }

    /********User Profile Controllers*********/
    @PostMapping("/create")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        System.out.println("creating user profile");
        return userProfileService.createUserProfile(userProfile);
    }

}
