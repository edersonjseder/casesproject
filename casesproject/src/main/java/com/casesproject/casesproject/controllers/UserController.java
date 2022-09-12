package com.casesproject.casesproject.controllers;

import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.services.UserService;
import com.casesproject.casesproject.utils.Traceable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	@Traceable
	public ResponseEntity<List<User>> getAllUsers() {
		var users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/cases/user/register", consumes = "application/json")
	public User registerUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

}

