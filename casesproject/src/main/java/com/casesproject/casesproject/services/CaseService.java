package com.casesproject.casesproject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.domain.Note;
import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.enums.Status;
import com.casesproject.casesproject.exceptions.ResourceNotFoundException;
import com.casesproject.casesproject.repositories.CaseRepository;
import com.casesproject.casesproject.repositories.NoteRepository;
import com.casesproject.casesproject.repositories.UserRepository;
import com.casesproject.casesproject.repositories.dto.CaseDto;

@Service
@Transactional
public class CaseService {
	private final CaseRepository caseRepository;
	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	public CaseService(CaseRepository caseRepository,
					   NoteRepository noteRepository,
					   UserRepository userRepository) {
		this.caseRepository = caseRepository;
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	public List<Case> getAllCasesWithStatus(Status status) {
		return caseRepository.findAllByStatus(status);
	}
	
	public List<Case> getCasesByUserId(Integer userId) {
		return caseRepository.findAllByUserId(userId);
	}
	
	public List<Case> getCasesByUserIdAndStatus(Integer userId, Status status) {
		return caseRepository.findAllByStatusAndUserId(status, userId);
	}
	
	public Case getCaseById(Integer caseId) {
		return caseRepository.getById(caseId);
	}
	
	public Case createCase(CaseDto toCreate) {
		User user = new User();
		try {
			user = userRepository.findUserByEmail(toCreate.getUserEmail())
					.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + toCreate.getUserEmail()));
		} catch (ResourceNotFoundException e) {
			user = null;
		}
		
		Case mCase = caseRepository.save(Case.builder()
				.status(Status.valueOf(toCreate.getStatus().toUpperCase()))
				.severity(toCreate.getSeverity())
				.title(toCreate.getTitle())
				.description(toCreate.getDescription())
				.user(user)
				.build());
		
		noteRepository.save(Note.builder().details(toCreate.getNoteDetail()).mCase(mCase).build());
		
		return mCase;
	}
}
