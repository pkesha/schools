package com.ga.contentbackend.controller;


import com.ga.contentbackend.model.Request.LoginRequest;
import com.ga.contentbackend.model.User;
import com.ga.contentbackend.model.UserProfile;
import com.ga.contentbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User userObject){
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("calling loginUser ==>");
        return userService.loginUser(loginRequest);
    }

    /********User Profile Controllers*********/
    @PostMapping("/{userId}")
    public void createUserProfile(@PathVariable Long userId,
                                         @RequestBody UserProfile userProfile) {
        System.out.println("creating user profile");
       // return userService.loginUser(loginRequest);
    }

}
