package com.casesproject.casesproject.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.enums.Status;
import com.casesproject.casesproject.repositories.dto.CaseDto;
import com.casesproject.casesproject.services.CaseService;

@RestController
@RequestMapping("/api")
public class CaseResource {
	private final CaseService caseService;
	public CaseResource(CaseService caseService) {
		this.caseService = caseService;
	}
	
	@GetMapping("/cases/status/{status}")
	public ResponseEntity<List<Case>> getCaseWithStatus(@PathVariable Status status) {
		List<Case> cases = caseService.getAllCasesWithStatus(status);
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/user/{userId}")
	public ResponseEntity<List<Case>> getOpenCases(@PathVariable Integer userId) {
		List<Case> cases = caseService.getCasesByUserId(userId);
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/user/{userId}/status/{status}")
	public ResponseEntity<List<Case>> getOpenCases(@PathVariable Integer userId, @PathVariable Status status) {
		List<Case> cases = caseService.getCasesByUserIdAndStatus(userId, status);
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/{caseId}")
	public ResponseEntity<Case> getCase(@PathVariable Integer caseId) {
		Case mCase = caseService.getCaseById(caseId);
		return new ResponseEntity<>(mCase, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cases/create", consumes = "application/json")
	public ResponseEntity<Case> createCase(@RequestBody CaseDto caseDto) {
		Case createdCase = caseService.createCase(caseDto);
		return new ResponseEntity<>(createdCase, HttpStatus.CREATED);
	}
}
