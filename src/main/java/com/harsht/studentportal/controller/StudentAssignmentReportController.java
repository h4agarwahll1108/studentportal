package com.harsht.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsht.studentportal.model.StudentAssignmentReport;
import com.harsht.studentportal.service.StudentAssignmentReportService;

@RestController
@RequestMapping("/student/reports")
@CrossOrigin("*")

public class StudentAssignmentReportController {

	@Autowired
	private StudentAssignmentReportService studentAssignmentReportService;

	// Get Report of a Student
	@GetMapping("/{sId}")
	public ResponseEntity<List<StudentAssignmentReport>> getStudentReport(@PathVariable("sId") Long sId) {

		return ResponseEntity.ok(this.studentAssignmentReportService.getStudentReport(sId));
	}

	// Trigger job for processing scoze result
	@GetMapping("/triggerkeportJob")
	public ResponseEntity<String> triggerReportJob() {
		
		this.studentAssignmentReportService.processAssignmentSubmission();
		return ResponseEntity.ok("Report Generation Job Successfull");

	}
}
