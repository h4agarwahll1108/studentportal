package com.harsht.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsht.studentportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	Boolean existsByUsername(String username);
}
