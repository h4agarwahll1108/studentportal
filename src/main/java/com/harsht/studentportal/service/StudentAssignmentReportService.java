package com.harsht.studentportal.service;

import java.util.List;

import com.harsht.studentportal.model.StudentAssignmentReport;

public interface StudentAssignmentReportService {

	List<StudentAssignmentReport> getStudentReport(Long sId);

	public void processAssignmentSubmission();

}
