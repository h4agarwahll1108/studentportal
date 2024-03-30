package com.harsht.studentportal.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private long sId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "city")
	private String city;

	@ManyToOne
	@JoinColumn(name = "d_id")
	private Department department;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "active_flag")
	private boolean activeFlag;

// This side is the owner
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "ASSIGNMENT_STUDENT", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "assignment_id"))
	private Set<Assignment> assignments;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Set<StudentAssignmentReport> studentAssignmentReport;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Set<StudentAssignmentSubmission> studentAssignmentSubmission;

	public Student(String firstName, String lastName, String city, Department department, LocalDateTime createdDate,
			LocalDateTime updatedDate, boolean activeFlag) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.department = department;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.activeFlag = activeFlag;

	}

// This method will allow to add assignment one by one. ([Instead of using Set
	// Method use below method for assignment]
	public void addAssignments(Assignment assig) {
		this.assignments.add(assig);
		assig.getStudents().add(this);
	}
}
