package com.harsht.studentportal.service;

import java.util.List;

import com.harsht.studentportal.model.Department;

public interface DepartmentService {

	public Department addDepartment(Department department);

	public Department updateDepartment(Department department);

	public void deactivateDepartmentById(Long dId);

	public Department getDepartmentById(long dId);

	List<Department> getAllDepartment();

}
