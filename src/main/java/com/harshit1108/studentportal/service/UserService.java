package com.harshit1108.studentportal.service;

import java.util.Set;

import com.harshit1108.studentportal.model.User;
import com.harshit1108.studentportal.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUser(String Username);

	public void deleteUser(Long userId);

}
