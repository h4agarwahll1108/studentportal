package com.harsht.studentportal.service.Implementation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsht.studentportal.model.StudentAssignmentReport;
import com.harsht.studentportal.model.StudentAssignmentSubmission;
import com.harsht.studentportal.repository.StudentAssignmentReportRepository;
import com.harsht.studentportal.repository.StudentAssignmentSubmissionRepository;
import com.harsht.studentportal.service.StudentAssignmentReportService;

import jakarta.transaction.Transactional;

@Service
public class StudentAssignmentReportServiceImpl implements StudentAssignmentReportService {

	@Autowired
	private StudentAssignmentSubmissionRepository studentAssignmentSubmissionRepository;

	@Autowired
	private StudentAssignmentReportRepository studentAssignmentReportRepository;

	@Override
	public List<StudentAssignmentReport> getStudentReport(Long sId) {
		return this.studentAssignmentReportRepository.findByStudentId(sId);
	}

	@Override
	@Transactional
	public void processAssignmentSubmission() {

		List<StudentAssignmentSubmission> unprocess = studentAssignmentSubmissionRepository.findByProcessedFalse();

		for (StudentAssignmentSubmission sub : unprocess) {
			String score = calculateScore(sub);
			// score Math.round(score 10000.0) / 10000.0;
			// String.format(".if", score);
			StudentAssignmentReport report = new StudentAssignmentReport();
			report.setStudent(sub.getStudent());
			report.setAssignment(sub.getAssignment());
			report.setScore(score);
			report.setCreatedDate(LocalDateTime.now());
			this.studentAssignmentReportRepository.save(report);
			sub.setProcessed(true);
			this.studentAssignmentSubmissionRepository.save(sub);
		}
	}

	@Transactional
	private String calculateScore(StudentAssignmentSubmission sub) {
		// fetch the submission date and assignment start date.
		LocalDateTime submissionDate = sub.getSubmissionDate();
		LocalDateTime assignmentStartDate = sub.getAssignment().getAssignmentStartDate();
		// Calculate time difference in ms.
		long timeInMillis = ChronoUnit.MILLIS.between(assignmentStartDate, submissionDate);
		double filesize = (double) sub.getFileSize() / 1024;
		double result = filesize + timeInMillis;
		return String.format("%.4f", result);
	}
}