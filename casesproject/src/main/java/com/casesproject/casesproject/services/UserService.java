package com.casesproject.casesproject.services;

import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.exceptions.UserEmailAlreadyExistsException;
import com.casesproject.casesproject.repositories.UserRepository;
import com.casesproject.casesproject.utils.UniqueIdGen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User newUser) {
		var uniqueIdGen = new UniqueIdGen();
		newUser.setId(uniqueIdGen.idGen());
		try {
			return userRepository.save(newUser);
		} catch (Exception e) {
			throw new UserEmailAlreadyExistsException(newUser.getEmail());
		}
	}
}
