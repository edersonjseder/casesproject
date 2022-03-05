package com.casesproject.casesproject.services;

import org.springframework.stereotype.Service;

import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.exceptions.UserEmailAlreadyExistsException;
import com.casesproject.casesproject.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User newUser) {
		try {			
			return userRepository.save(newUser);
		} catch (Exception e) {
			throw new UserEmailAlreadyExistsException("Email '" + newUser.getEmail() + "' already exist");
		}
	}
}
