package com.harshit1108.studentportal.service;

import java.util.List;

import com.harshit1108.studentportal.model.StudentAssignmentReport;

public interface StudentAssignmentReportService {

	List<StudentAssignmentReport> getStudentReport(Long sId);

	public void processAssignmentSubmission();

}
