package com.harshit1108.studentportal.service.Implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit1108.studentportal.model.Assignment;
import com.harshit1108.studentportal.model.Department;
import com.harshit1108.studentportal.model.Student;
import com.harshit1108.studentportal.repository.AssignmentRepository;
import com.harshit1108.studentportal.repository.DepartmentRepository;
import com.harshit1108.studentportal.repository.StudentRepository;
import com.harshit1108.studentportal.service.StudentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	// Add new Student [Student with same name and city and exits]
	@Override
	@Transactional
	public Student addStudent(Student student) {

		student.setCreatedDate(LocalDateTime.now());
		student.setUpdatedDate(LocalDateTime.now());
		student.setActiveFlag(true);
		return this.studentRepository.save(student);
	}

	// Update Student
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		Student stud = getStudentById(student.getSId());
		student.setCreatedDate(stud.getCreatedDate());
		student.setUpdatedDate(LocalDateTime.now());

		return this.studentRepository.save(student);
	}

	// Fetch Student details by Id
	@Override
	public Student getStudentById(Long sId) {
		return this.studentRepository.findById(sId).get();
	}

	// Fetch list of all student from database @Override
	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	// Fetch list of all student by department name @Override

	public List<Student> getAllStudentByDepartmentName(String departmentName) {

		return this.studentRepository.findByDepartment_DepartmentName(departmentName);

	}

	// Deactivate active flag by id
	@Override
	@Transactional
	public void deactivateStudentById(Long sId) {
		Student stud = this.studentRepository.findById(sId).orElseThrow(EntityNotFoundException::new);
		System.out.println(stud.getSId());

		if (stud != null) {

			stud.setActiveFlag(false);
			this.studentRepository.save(stud);
		}
	}

	// Assign assignment to Student
	@Override
	@Transactional
	public Student addAssignmentToStudent(Long sId, Long aId) {
		Student stud = this.studentRepository.findById(sId).get();
		Assignment assig = this.assignmentRepository.findById(aId).get();
		stud.addAssignments(assig);
		return this.studentRepository.save(stud);
	}

	// Assign Department to Student
	@Override
	@Transactional
	public void assignDepartmentToStudent(Long sId, Long dId) {
		Student stud = this.studentRepository.findById(sId).orElseThrow(EntityNotFoundException::new);

		Department depart = this.departmentRepository.findById(dId).orElseThrow(EntityNotFoundException::new);

		// stud.setDepartment (depart);
		depart.addStudentToDepartment(stud);
		this.studentRepository.save(stud);
	}

	// Delete Student By Id
	@Override
	@Transactional
	public void deleteStudentById(Long sId) {
		Student student = new Student();
		student.setSId(sId);
		this.studentRepository.delete(student);

	}
}
