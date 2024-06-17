package com.harshit1108.studentportal.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "ASSIGNMENT")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private long aId;

	@Column(name = "assignment_name")
	private String assignmentName;

	@Column(name = "assignment_start_date")
	private LocalDateTime assignmentStartDate;

	@Column(name = "assignment_end_date")
	private LocalDateTime assignmentEndDate;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "active_flag")
	private boolean activeFlag;

	@ManyToMany(mappedBy = "assignments", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Student> students;

	@OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Set<StudentAssignmentReport> studentAssignmentReport;

	@OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Set<StudentAssignmentSubmission> studentAssignmentSubmission;

	public Assignment(String assignmentName, LocalDateTime assignmentStartDate, LocalDateTime assignmentEndDate,
			LocalDateTime createdDate, LocalDateTime updatedDate, boolean activeFlag) {

		super();
		this.assignmentName = assignmentName;
		this.assignmentStartDate = assignmentStartDate;
		this.assignmentEndDate = assignmentEndDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.activeFlag = activeFlag;
	}
}