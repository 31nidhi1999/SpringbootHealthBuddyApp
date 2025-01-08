package com.health.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.health.dto.response.ApiResponse;
import com.health.entities.User;
import java.util.List;


public interface IUserRepository extends JpaRepository<User, Long> {
	
	Boolean existsByEmail(String email);

}
