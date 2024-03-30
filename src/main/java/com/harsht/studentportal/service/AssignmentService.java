package com.harsht.studentportal.service;

import com.harsht.studentportal.model.Assignment;

public interface AssignmentService {

	public Assignment addAssignment(Assignment assignment);

	public Assignment updateAssignment(Assignment assignment);

	public void deactivateAssignmentById(Long aId);

	public Assignment getAssignmentById(long aId);

}
