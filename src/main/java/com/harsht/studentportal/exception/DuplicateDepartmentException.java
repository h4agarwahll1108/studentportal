package com.harsht.studentportal.exception;

public class DuplicateDepartmentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateDepartmentException(String s) {
		super(s);

	}

	public DuplicateDepartmentException() {
		super("Department not found!!");

	}

}
