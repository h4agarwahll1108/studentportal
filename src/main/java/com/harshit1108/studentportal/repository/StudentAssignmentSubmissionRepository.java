package com.harshit1108.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit1108.studentportal.model.StudentAssignmentSubmission;

public interface StudentAssignmentSubmissionRepository extends JpaRepository<StudentAssignmentSubmission, Long> {

	List<StudentAssignmentSubmission> findByProcessedFalse();
}
