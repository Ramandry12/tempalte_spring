package com.example.spinr_course.model.response;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserRes {
    private UUID id;
    private String username;
    private String name;
    private String email;
}
