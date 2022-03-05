package com.casesproject.casesproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.services.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/cases/user/register", consumes = "application/json")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		
		User newUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

}

