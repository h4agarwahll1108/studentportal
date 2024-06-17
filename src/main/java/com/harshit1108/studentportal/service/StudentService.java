package com.harshit1108.studentportal.service;

import java.util.List;

import com.harshit1108.studentportal.model.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public List<Student> getAllStudents();

	public void deactivateStudentById(Long sId);

	public void assignDepartmentToStudent(Long sId, Long dId);

	public List<Student> getAllStudentByDepartmentName(String departmentName);

	public Student addAssignmentToStudent(Long sId, Long aId);

	public Student getStudentById(Long sId);

	public void deleteStudentById(Long sId);

}
