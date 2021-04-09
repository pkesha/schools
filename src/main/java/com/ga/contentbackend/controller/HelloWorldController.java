package com.ga.contentbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//localhost:9092/categories/{categoryId}/reviews/{reviewId}/comments/{commentId}

    @GetMapping(path="/hello")
    public String getHello(){
        return "Hello World";
    }
}
