package com.harsht.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsht.studentportal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
