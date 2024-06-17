package com.harshit1108.studentportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.harshit1108.studentportal.exception.AssignmentSubmissionException;
import com.harshit1108.studentportal.model.Student;

public interface StudentAssignmentSubmissionService {

	void submitAssignment(Long sId, Long aId, MultipartFile file) throws AssignmentSubmissionException;

	List<Student> getStudentsWithoutSubmission();

}
