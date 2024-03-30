package com.harsht.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsht.studentportal.model.Department;
import com.harsht.studentportal.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// End point for adding new department.
	@PostMapping("/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return ResponseEntity.ok(this.departmentService.addDepartment(department));
	}

	// End point for updating department.
	@PutMapping("/")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		return ResponseEntity.ok(this.departmentService.updateDepartment(department));
	}

	// End point for deactivating active flag by id.
	@PatchMapping("/deactivate/{dId}")
	public ResponseEntity<String> deactivateDepartmentById(@PathVariable("dId") Long dId) {

		this.departmentService.deactivateDepartmentById(dId);
		return ResponseEntity.ok("Successfully Deactivated!!");
	}

	// Get list of all Student
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllDepartment() {
		return ResponseEntity.ok(this.departmentService.getAllDepartment());
	}
}
