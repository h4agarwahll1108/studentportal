package com.harshit1108.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit1108.studentportal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
