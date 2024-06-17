package com.harshit1108.studentportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit1108.studentportal.model.Assignment;
import com.harshit1108.studentportal.service.AssignmentService;

@RestController
@RequestMapping("/assignments")
@CrossOrigin("")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	// Add Assignment
	@PostMapping("/")
	public ResponseEntity<Assignment> addAssignment(@RequestBody Assignment assignment) {

		return ResponseEntity.ok(this.assignmentService.addAssignment(assignment));
	}

	// Update Assignment
	@PutMapping("/")
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {

		return ResponseEntity.ok(this.assignmentService.updateAssignment(assignment));

	}

	// Deactivate By Id
	@PatchMapping("/deactivate/{aId}")
	public ResponseEntity<String> deactivateAssignmentById(@PathVariable("aId") Long aId) {

		this.assignmentService.deactivateAssignmentById(aId);
		return ResponseEntity.ok("Successfully Deactivated!!");

	}
}