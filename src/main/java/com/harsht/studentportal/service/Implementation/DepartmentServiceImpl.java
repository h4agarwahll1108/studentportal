package com.harsht.studentportal.service.Implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsht.studentportal.exception.DuplicateDepartmentException;
import com.harsht.studentportal.model.Department;
import com.harsht.studentportal.repository.DepartmentRepository;
import com.harsht.studentportal.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	// Adding Department.
	@Override
	@Transactional
	public Department addDepartment(Department department) {
		if (departmentRepository.existsByDepartmentName(department.getDepartmentName())) {
			throw new DuplicateDepartmentException("Department with same name already exists!!");
		}
		department.setCreatedDate(LocalDateTime.now());
		department.setUpdatedDate(LocalDateTime.now());
		department.setActiveFlag(true);
		return this.departmentRepository.save(department);
	}

	// Updating Department
	@Override
	@Transactional
	public Department updateDepartment(Department department) {
		Department depart = getDepartmentById(department.getDId());
		department.setCreatedDate(depart.getCreatedDate());
		department.setUpdatedDate(LocalDateTime.now());
		return this.departmentRepository.save(department);
	}

	// DEACTIVATE (mark active_flag as N)
	@Override
	@Transactional
	public void deactivateDepartmentById(Long dId) {
		Department depart = this.departmentRepository.findById(dId).orElseThrow(EntityNotFoundException::new);
		if (depart != null) {
			depart.setActiveFlag(false);
			departmentRepository.save(depart);
		}
	}

	// Get Department By Id.
	@Override
	public Department getDepartmentById(long dId) {
		return this.departmentRepository.findById(dId).get();
	}

	@Override
	public List<Department> getAllDepartment() {
		return this.departmentRepository.findAll();

	}
}
