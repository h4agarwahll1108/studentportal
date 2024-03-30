package com.harsht.studentportal.exception;

public class AssignmentSubmissionException extends RuntimeException {

	private static final long serialVersionUID = 2L;

	public AssignmentSubmissionException(String s) {
		super(s);
	}

	public AssignmentSubmissionException() {
		super("Assignment not found!!");

	}
}