package com.harsht.studentportal.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "STUDENT_ASSIGNMENT_REPORT")
public class StudentAssignmentReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private long reportId;

	@ManyToOne
	@JoinColumn(name = "s_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "a_id")
	private Assignment assignment;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "score")
	private String score;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public StudentAssignmentReport(Student student, Assignment assignment, String score, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.student = student;
		this.assignment = assignment;
		this.score = score;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

}