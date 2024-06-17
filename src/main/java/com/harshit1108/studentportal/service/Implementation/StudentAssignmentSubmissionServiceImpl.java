package com.harshit1108.studentportal.service.Implementation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.harshit1108.studentportal.exception.AssignmentSubmissionException;
import com.harshit1108.studentportal.model.Assignment;
import com.harshit1108.studentportal.model.Student;
import com.harshit1108.studentportal.model.StudentAssignmentSubmission;
import com.harshit1108.studentportal.repository.AssignmentRepository;
import com.harshit1108.studentportal.repository.StudentAssignmentSubmissionRepository;
import com.harshit1108.studentportal.repository.StudentRepository;
import com.harshit1108.studentportal.service.StudentAssignmentSubmissionService;

import jakarta.transaction.Transactional;

@Service
public class StudentAssignmentSubmissionServiceImpl implements StudentAssignmentSubmissionService {

	@Autowired
	private StudentAssignmentSubmissionRepository studentAssignmentSubmissionRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	@Transactional
	public void submitAssignment(Long sId, Long aId, MultipartFile file) throws AssignmentSubmissionException {

		Assignment assig = this.assignmentRepository.findById(aId)
				.orElseThrow(() -> new AssignmentSubmissionException("Assignment not Found!!"));

		Student stud = this.studentRepository.findById(sId)
				.orElseThrow(() -> new AssignmentSubmissionException("Student not Found!!"));

		if (!stud.getAssignments().contains(assig)) {

			throw new AssignmentSubmissionException("Student not assigned to the given Assignment");

		}

		if (!assig.isActiveFlag() || assig.getAssignmentEndDate().isBefore(LocalDateTime.now())) {

			throw new AssignmentSubmissionException("Assignment is not active or submission date is passed");

		}

		try {
			StudentAssignmentSubmission submission = new StudentAssignmentSubmission();
			submission.setAssignment(assig);
			submission.setStudent(stud);
			submission.setSubmissionDate(LocalDateTime.now());
			submission.setFile(file.getBytes());
			submission.setFileSize(file.getSize());
			submission.setFileName(file.getOriginalFilename());
			submission.setSubmittedBy(stud.getFirstName() + " " + stud.getLastName());
			submission.setProcessed(false);
			studentAssignmentSubmissionRepository.save(submission);
		} catch (IOException e) {
			throw new AssignmentSubmissionException("Error in submitting");
		}

	}

	@Override
	public List<Student> getStudentsWithoutSubmission() {
		return this.studentRepository.findStudentWithoutSubmission();

	}
}
