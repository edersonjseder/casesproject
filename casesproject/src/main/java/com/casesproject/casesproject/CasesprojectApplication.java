package com.casesproject.casesproject;

import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * In this application I'm manually creating my own @RestController controllers
 * I'm manually defining methods for access: @GetMapping
 */
@SpringBootApplication
public class CasesprojectApplication {//implements CommandLineRunner {

	@Value("${webmaster.firstName}")
	private String firstName;

	@Value("${webmaster.lastName}")
	private String lastName;

	@Value("${webmaster.email}")
	private String email;

	private UserService userService;

	public CasesprojectApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CasesprojectApplication.class, args);
	}
/*
	@Override
	public void run(String... args) {
		userService.saveUser(User.builder().firstName(firstName).lastName(lastName).email(email).build());
	}*/
}
