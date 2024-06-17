package com.harshit1108.studentportal.service.Implementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit1108.studentportal.model.Assignment;
import com.harshit1108.studentportal.repository.AssignmentRepository;
import com.harshit1108.studentportal.service.AssignmentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	// Add Assignment
	@Override
	@Transactional
	public Assignment addAssignment(Assignment assignment) {

		assignment.setCreatedDate(LocalDateTime.now());
		assignment.setUpdatedDate(LocalDateTime.now());
		assignment.setActiveFlag(true);
		return this.assignmentRepository.save(assignment);
	}

	// Update Assignment
	@Override
	@Transactional
	public Assignment updateAssignment(Assignment assignment) {
		Assignment assig = getAssignmentById(assignment.getAId());
		assignment.setCreatedDate(assig.getCreatedDate());
		assignment.setUpdatedDate(LocalDateTime.now());
		return this.assignmentRepository.save(assignment);
	}

	// Deactivate active flag @Override
	@Transactional
	public void deactivateAssignmentById(Long aId) {

		Assignment assig = this.assignmentRepository.findById(aId).orElseThrow(EntityNotFoundException::new);
		if (assig != null) {
			assig.setActiveFlag(false);
			assignmentRepository.save(assig);
		}
	}

	// Get Assignment By Id
	@Override
	public Assignment getAssignmentById(long aId) {
		return this.assignmentRepository.findById(aId).get();
	}
}
