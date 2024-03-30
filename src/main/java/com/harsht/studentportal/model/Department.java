package com.harsht.studentportal.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id")
	private long dId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "hod_name")
	private String hodName;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "active_flag")
	private boolean activeFlag;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Set<Student> students;

	public Department(String departmentName, String hodName, LocalDateTime createdDate, LocalDateTime updatedDate,
			boolean activeFlag) {
		super();
		this.departmentName = departmentName;
		this.hodName = hodName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.activeFlag = activeFlag;

	}

	public void addStudentToDepartment(Student student) {
		if (student != null) {
			if (students == null) {
				students = new HashSet<>();
			}
			student.setDepartment(this);
			students.add(student);
		}
	}
}
