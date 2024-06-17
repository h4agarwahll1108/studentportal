package com.harshit1108.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit1108.studentportal.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	boolean existsByDepartmentName (Object object);

}
