package com.harshit1108.studentportal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "STUDENT_ASSIGNMENT_SUBMISSION")
public class StudentAssignmentSubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "submission_id")
	private long submissionId;

	@ManyToOne
	@JoinColumn(name = "a_id")
	private Assignment assignment;

	@ManyToOne
	@JoinColumn(name = "s_id")
	private Student student;

	@Column(name = "submission_date")
	private LocalDateTime submissionDate;

	@Lob
	@Column(name = "file", columnDefinition="LONGBLOB")
	private byte[] file;

	@Column(name = "file_size")
	private long fileSize;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "submitted_by")
	private String submittedBy;

	@Column(name = "processed")
	private boolean processed;

	public StudentAssignmentSubmission(Assignment assignment, Student student, LocalDateTime submissionDate,
			byte[] file, long fileSize, String fileName, String submittedBy, boolean processed) {
		super();
		this.assignment = assignment;
		this.student = student;
		this.submissionDate = submissionDate;
		this.file = file;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.submittedBy = submittedBy;
		this.processed = processed;
	}

}
