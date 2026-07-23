package com.example.springmapstruct.repository;

import com.example.springmapstruct.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAppRepository extends JpaRepository<UserApp, UUID> {

}
