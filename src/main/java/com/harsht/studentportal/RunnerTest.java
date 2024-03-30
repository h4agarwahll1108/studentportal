//package com.harsht.studentportal;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.harsht.studentportal.model.Assignment;
//import com.harsht.studentportal.model.Department;
//import com.harsht.studentportal.model.Role;
//import com.harsht.studentportal.model.Student;
//import com.harsht.studentportal.model.User;
//import com.harsht.studentportal.model.UserRole;
//import com.harsht.studentportal.repository.AssignmentRepository;
//import com.harsht.studentportal.repository.DepartmentRepository;
//import com.harsht.studentportal.repository.StudentRepository;
//import com.harsht.studentportal.service.UserService;
//import com.harsht.studentportal.service.Implementation.StudentServiceImpl;
//
//@Component
//public class RunnerTest implements CommandLineRunner {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Autowired
//	private AssignmentRepository assignmentRepository;
//
//	@Autowired
//	private DepartmentRepository departmentRepository;
//
//	@Autowired
//	private StudentServiceImpl studentServiceImpl;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		User user = new User();
//
//		user.setUsername("harshit");
//		user.setPassword(this.bCryptPasswordEncoder.encode("root123"));
//		Role rolel = new Role();
//
//		rolel.setRoleld(1L);
//		rolel.setRolename("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(rolel);
//
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//		User userl = this.userService.createUser(user, userRoleSet);
//
//		// Adding Student
//
//		Student studl = new Student();
//		studl.setFirstName("Harshit");
//		studl.setLastName("Agarwal");
//		studl.setCity("Pune");
//		studl.setCreatedDate(LocalDateTime.now());
//		studl.setUpdatedDate(LocalDateTime.now());
//		studl.setActiveFlag(true);
//		studentRepository.save(studl);
//
//		Student stud2 = new Student();
//		stud2.setFirstName("Akashl");
//		stud2.setLastName("Verma");
//		stud2.setCity("Mumbai");
//		stud2.setCreatedDate(LocalDateTime.now().minusDays(1));
//		stud2.setUpdatedDate(LocalDateTime.now());
//		stud2.setActiveFlag(true);
//		studentRepository.save(stud2);
//
//		Student stud3 = new Student();
//		stud3.setFirstName("Shivami");
//		stud3.setLastName("Dubey");
//		stud3.setActiveFlag(true);
//		stud3.setCity("Mathura");
//		stud3.setCreatedDate(LocalDateTime.now());
//		stud3.setUpdatedDate(LocalDateTime.now().plusDays(1));
//		studentRepository.save(stud3);
//
//		Student stud4 = new Student();
//		stud4.setFirstName("Harshit");
//		stud4.setLastName("Agarwal");
//		stud4.setCity("Pune");
//		stud4.setCreatedDate(LocalDateTime.now());
//		stud4.setUpdatedDate(LocalDateTime.now());
//		stud4.setActiveFlag(true);
//		studentRepository.save(stud4);
//
//		// Adding Department Department depart1 = new Department (); depart1.setDepartmentName("ECE"); depart1.setHodName ("HOD ECE"); depart1.setCreatedDate (LocalDateTime.now()); departl.setUpdatedDate (LocalDateTime.now()); departl.setActiveFlag(true); departmentRepository.save (depart1);
//
//		//studentServiceImpl.assignDepartmentToStudent (IL, 1L);
//		Department depart2 = new Department();
//		depart2.setDepartmentName("IT");
//		depart2.setHodName("HOD_IT");
//		depart2.setCreatedDate(LocalDateTime.now().minusDays(1));
//		depart2.setUpdatedDate(LocalDateTime.now());
//		depart2.setActiveFlag(true);
//		departmentRepository.save(depart2);
//		studentServiceImpl.assignDepartmentToStudent(2L, 1L);
//
//		Department depart3 = new Department();
//		depart3.setDepartmentName("CS");
//		depart3.setHodName("HOD_CS");
//		depart3.setCreatedDate(LocalDateTime.now().plusDays(1));
//		depart3.setUpdatedDate(LocalDateTime.now().plusDays(1));
//		depart3.setActiveFlag(true);
//		departmentRepository.save(depart3);
//
//		// Add Assignment
//
//		// always valid assignment 
//		Assignment assigl = new Assignment();
//		assigl.setAssignmentName("English Assignment");
//		assigl.setAssignmentStartDate(LocalDateTime.now().minusDays(2));
//		assigl.setAssignmentEndDate(LocalDateTime.now().plusDays(5));
//		assigl.setCreatedDate(LocalDateTime.now().minusDays(3));
//		assigl.setUpdatedDate(LocalDateTime.now().minusDays(2));
//		assigl.setActiveFlag(true);
//		assignmentRepository.save(assigl);
//
//		// End date passed from local date now
//		Assignment assig2 = new Assignment();
//		assig2.setAssignmentName("Java Assignment");
//		assig2.setAssignmentStartDate(LocalDateTime.now().minusDays(4));
//		assig2.setAssignmentEndDate(LocalDateTime.now().minusDays(1));
//		assig2.setCreatedDate(LocalDateTime.now().minusDays(5));
//		assig2.setUpdatedDate(LocalDateTime.now().minusDays(4));
//		assig2.setActiveFlag(true);
//		assignmentRepository.save(assig2);
//
//		// Normal
//		Assignment assig3 = new Assignment();
//		assig3.setAssignmentName("Maths Assignment");
//		assig3.setAssignmentStartDate(LocalDateTime.now());
//		assig3.setAssignmentEndDate(LocalDateTime.now().plusDays(2));
//		assig3.setCreatedDate(LocalDateTime.now());
//		assig3.setUpdatedDate(LocalDateTime.now());
//		assig3.setActiveFlag(true);
//		assignmentRepository.save(assig3);
//	}
//}
