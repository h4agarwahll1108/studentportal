package com.harsht.studentportal.service;

import java.util.Set;

import com.harsht.studentportal.model.User;
import com.harsht.studentportal.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUser(String Username);

	public void deleteUser(Long userId);

}
