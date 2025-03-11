package com.example.spinr_course.service;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spinr_course.entity.UserEntity;
import com.example.spinr_course.model.request.UserReq;
import com.example.spinr_course.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }



    public ResponseEntity<LinkedHashMap<String, Object>> registerUser(UserReq userReq) {
        LinkedHashMap<String, Object> response = new LinkedHashMap<>();

        try {
            Optional<UserEntity> existingUser = userRepository.findByUsername(userReq.getUsername());
            if (existingUser.isPresent()) {
                response.put("status", "error");
                response.put("message", "Username sudah digunakan!");
                return ResponseEntity.badRequest().body(response);
            }

            String hashedPassword = passwordEncoder.encode(userReq.getPassword());

            UserEntity newUser = new UserEntity();
            newUser.setUuid(UUID.randomUUID().toString());
            newUser.setUsername(userReq.getUsername());
            newUser.setName(userReq.getName());
            newUser.setEmail(userReq.getEmail());
            newUser.setPassword(hashedPassword);

            userRepository.save(newUser);

            response.put("status", "SUkSES");
            response.put("message", "User berhasil didaftarkan!");
            response.put("user", newUser.getUsername());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Terjadi kesalahan saat registrasi: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }



}
