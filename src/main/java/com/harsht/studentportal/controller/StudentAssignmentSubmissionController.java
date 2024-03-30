package com.harsht.studentportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harsht.studentportal.exception.AssignmentSubmissionException;
import com.harsht.studentportal.service.StudentAssignmentSubmissionService;

@RestController
@RequestMapping("/assignments/submissions")
@CrossOrigin("*")
public class StudentAssignmentSubmissionController {

	@Autowired
	private StudentAssignmentSubmissionService studentAssignmentSubmissionService;

	@PostMapping("/submit/{sId}/{aId}")
	public ResponseEntity<String> submitAssignment(@PathVariable Long sId, @PathVariable Long aId,
			@RequestParam("file") MultipartFile file) {

		if (file == null || file.isEmpty()) {
			throw new AssignmentSubmissionException("File is Empty or not present");
		}
		this.studentAssignmentSubmissionService.submitAssignment(sId, aId, file);
		return ResponseEntity.ok("Successful!!");
	}
}
