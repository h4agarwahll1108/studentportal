package com.harshit1108.studentportal.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harshit1108.studentportal.model.User;
import com.harshit1108.studentportal.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return user;
	}
}