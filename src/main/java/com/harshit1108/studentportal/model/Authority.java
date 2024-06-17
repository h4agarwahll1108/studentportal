package com.harshit1108.studentportal.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String authority;

	@Override
	public String getAuthority() {
		return this.authority;

	}
}