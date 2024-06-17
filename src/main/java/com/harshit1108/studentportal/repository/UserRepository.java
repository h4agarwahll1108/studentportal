package com.harshit1108.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit1108.studentportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	Boolean existsByUsername(String username);
}
