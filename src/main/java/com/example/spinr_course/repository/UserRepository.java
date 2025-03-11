package com.example.spinr_course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spinr_course.entity.UserEntity;

import io.swagger.v3.oas.annotations.Hidden;



@Hidden
@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
