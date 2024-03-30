package com.harsht.studentportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.harsht.studentportal.exception.AssignmentSubmissionException;
import com.harsht.studentportal.model.Student;

public interface StudentAssignmentSubmissionService {

	void submitAssignment(Long sId, Long aId, MultipartFile file) throws AssignmentSubmissionException;

	List<Student> getStudentsWithoutSubmission();

}
