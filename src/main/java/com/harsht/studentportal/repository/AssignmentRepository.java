package com.harsht.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsht.studentportal.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
