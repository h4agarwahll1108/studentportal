package com.harshit1108.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harshit1108.studentportal.model.StudentAssignmentReport;

public interface StudentAssignmentReportRepository extends JpaRepository<StudentAssignmentReport, Long> {

	@Query(value = "SELECT * FROM STUDENT_ASSIGNMENT_REPORT s WHERE s.s_id = :sId", nativeQuery = true)
	List<StudentAssignmentReport> findByStudentId(Long sId);

}
