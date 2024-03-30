package com.harsht.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsht.studentportal.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	boolean existsByDepartmentName (Object object);

}
