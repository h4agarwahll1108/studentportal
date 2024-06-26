package com.harshit1108.studentportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit1108.studentportal.model.Role;
import com.harshit1108.studentportal.model.User;
import com.harshit1108.studentportal.model.UserRole;
import com.harshit1108.studentportal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> rolel = new HashSet<>();
		// encoding the password with bCryptPasswordEncoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Role role = new Role();
		role.setRoleld(45L);
		role.setRolename("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		rolel.add(userRole);
		return this.userService.createUser(user, rolel);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userID) {
		this.userService.deleteUser(userID);
	}
}