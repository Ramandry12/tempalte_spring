package com.example.spinr_course.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserReq {
    @NotBlank
    private String username;
    @NotBlank
    private String name;    
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
