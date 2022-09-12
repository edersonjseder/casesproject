package com.casesproject.casesproject.controllers;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.enums.Status;
import com.casesproject.casesproject.repositories.dto.CaseDto;
import com.casesproject.casesproject.services.CaseService;
import com.casesproject.casesproject.utils.Traceable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaseResource {
	private final CaseService caseService;
	public CaseResource(CaseService caseService) {
		this.caseService = caseService;
	}

	@GetMapping("/cases")
	@Traceable
	public ResponseEntity<List<Case>> getAllCases() {
		List<Case> cases = caseService.getAllCases();
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/status/{status}")
	@Traceable
	public ResponseEntity<List<Case>> getCaseWithStatus(@PathVariable Status status) {
		List<Case> cases = caseService.getAllCasesWithStatus(status);
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/user/{userId}")
	public ResponseEntity<List<Case>> getOpenCases(@PathVariable Long userId) {
		List<Case> cases = caseService.getCasesByUserId(userId);
		return new ResponseEntity<>(cases, HttpStatus.OK);
	}
	
	@GetMapping("/cases/user/{userId}/status/{status}")
	@Traceable
	public List<Case> getOpenCases(@PathVariable Long userId, @PathVariable Status status) {
		return caseService.getCasesByUserIdAndStatus(userId, status);
	}
	
	@GetMapping("/cases/{caseId}")
	public Case getCase(@PathVariable Long caseId) {
		return caseService.getCaseById(caseId);
	}

	@Traceable
	@PostMapping(value = "/cases/create", consumes = "application/json")
	public ResponseEntity<Case> createCase(@RequestBody CaseDto caseDto) {
		Case createdCase = caseService.createCase(caseDto);
		return new ResponseEntity<>(createdCase, HttpStatus.CREATED);
	}
}
