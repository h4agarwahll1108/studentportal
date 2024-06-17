package com.harshit1108.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harshit1108.studentportal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// Get all students by department name (Student--department--department name)
	List<Student> findByDepartment_DepartmentName(String departmentName);

	// Get all students who have not submitted their assignments
	@Query(value = "SELECT * FROM STUDENTS WHERE NOT EXISTS (SELECT 1 FROM STUDENT_ASSIGNMENT_SUBMISSION sub"
			+ "WHERE sub.submission_id = s.s_id)", nativeQuery = true)
	List<Student> findStudentWithoutSubmission();
}
