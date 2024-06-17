package com.harshit1108.studentportal.service.Implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit1108.studentportal.model.User;
import com.harshit1108.studentportal.model.UserRole;
import com.harshit1108.studentportal.repository.RoleRepository;
import com.harshit1108.studentportal.repository.UserRepository;
import com.harshit1108.studentportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("user is already there!!");
			throw new Exception("User already present!!");

		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	// getting user by User name
	@Override
	public User getUser(String Username) {
		return this.userRepository.findByUsername(Username);
	}

	// delete user by id
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);

	}

}
