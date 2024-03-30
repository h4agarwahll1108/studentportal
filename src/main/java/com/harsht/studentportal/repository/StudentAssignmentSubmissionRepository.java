package com.harsht.studentportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsht.studentportal.model.StudentAssignmentSubmission;

public interface StudentAssignmentSubmissionRepository extends JpaRepository<StudentAssignmentSubmission, Long> {

	List<StudentAssignmentSubmission> findByProcessedFalse();
}
