package com.example.spinr_course.controller;

import java.util.LinkedHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spinr_course.model.request.UserReq;
import com.example.spinr_course.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/auth")
@Tag(name = "User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    

    @PostMapping("/register")
    public ResponseEntity<LinkedHashMap<String, Object>> registerUser(@RequestBody UserReq userReq) {
        return userService.registerUser(userReq);
    }
    
}
