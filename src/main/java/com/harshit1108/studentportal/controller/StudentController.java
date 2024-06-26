package com.harshit1108.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit1108.studentportal.model.Student;
import com.harshit1108.studentportal.service.StudentAssignmentSubmissionService;
import com.harshit1108.studentportal.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Tutorial", description = "Tutorial management APIs")
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentAssignmentSubmissionService studentAssignmentSubmissionService;

	// Add Student
	@Operation(description = "API to create students")
			@Parameter(name = "student", required = true, 
				example = "{\"firstName\":String," + "\"lastName\":String," +"\"city\":String}")
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "{\"response\":String}",
	                content = { @Content(mediaType = "application/json")})}) 
	         
	@PostMapping(value ="/")
		public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(this.studentService.addStudent(student));
	}

	// Update Student
	@PutMapping("/")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(this.studentService.updateStudent(student));
	}

	// Get list of all Student
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok(this.studentService.getAllStudents());
	}

	// Deactivate by Id
	@PatchMapping("/deactivate/{sId}")
	public ResponseEntity<String> deactivateStudentById(@PathVariable("sId") Long sId) {
		this.studentService.deactivateStudentById(sId);
		return ResponseEntity.ok("Successfully Deactivated");
	}

	// Assign Department To Student
	@PutMapping("/{sId}/assignDepartment/{dId}")
	public ResponseEntity<String> assignDepartmentToStudent(@PathVariable Long sId, @PathVariable Long dId) {
		this.studentService.assignDepartmentToStudent(sId, dId);
		return ResponseEntity.ok("Successfull!!");

	}

	// Assign Assignment To Student
	@PutMapping("/{sId}/assignAssignment/{aId}")
	public ResponseEntity<Student> addassignmentToStudent(@PathVariable Long sId, @PathVariable Long aId) {
		return ResponseEntity.ok(studentService.addAssignmentToStudent(sId, aId));
	}

	// Fetch list of Student By Department name
	@GetMapping("/{departmentName}")
	public ResponseEntity<List<Student>> getAllStudentByDepartmentName(
			@PathVariable("departmentName") String departmentName) {
		return ResponseEntity.ok(studentService.getAllStudentByDepartmentName(departmentName));
	}

	// Fetch all the student details who has not submitted the assignment
	@GetMapping("/withoutsubmissions")
	public ResponseEntity<List<Student>> getStudentsWithoutSubmission() {
		return ResponseEntity.ok(studentAssignmentSubmissionService.getStudentsWithoutSubmission());

	}

	// Get Student By Id
	@GetMapping("/id/{sId}")
	public Student getStudentById(@PathVariable("sId") Long sId) {
		return this.studentService.getStudentById(sId);
	}

	// Delete Student By Id
	@DeleteMapping("/{sId}")
	public void deleteStudentById(@PathVariable("sId") Long sId) {
		this.studentService.deleteStudentById(sId);
	}
}
