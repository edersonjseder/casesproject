package com.casesproject.casesproject.services;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.domain.User;
import com.casesproject.casesproject.enums.Status;
import com.casesproject.casesproject.exceptions.ResourceNotFoundException;
import com.casesproject.casesproject.repositories.CaseRepository;
import com.casesproject.casesproject.repositories.UserRepository;
import com.casesproject.casesproject.repositories.dto.CaseDto;
import com.casesproject.casesproject.utils.UniqueIdGen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class CaseService {
	private final CaseRepository caseRepository;
	private final NoteService noteService;
	private final UserRepository userRepository;

	public CaseService(CaseRepository caseRepository,
					   NoteService noteService,
					   UserRepository userRepository) {
		this.caseRepository = caseRepository;
		this.noteService = noteService;
		this.userRepository = userRepository;
	}

	public List<Case> getAllCases() {
		return caseRepository.findAll();
	}

	public List<Case> getAllCasesWithStatus(Status status) {
		return caseRepository.findAllByStatus(status);
	}
	
	public List<Case> getCasesByUserId(Long userId) {
		return caseRepository.findAllByUserId(userId);
	}
	
	public List<Case> getCasesByUserIdAndStatus(Long userId, Status status) {
		List<Case> cases = caseRepository.findAllByStatusAndUserId(status, userId);
		if (cases.isEmpty()) {
			throw new ResourceNotFoundException(userId.toString(), status.getCode());
		}
		return cases;
	}
	
	public Case getCaseById(Long caseId) {
		return caseRepository.findById(caseId).orElseThrow(() -> new ResourceNotFoundException(caseId.toString()));
	}

	public Case createCase(CaseDto toCreate) {
		User user;
		var uniqueIdGen = new UniqueIdGen();

		user = userRepository.findUserByEmail(toCreate.getUserEmail())
				.orElseThrow(() -> new ResourceNotFoundException(toCreate.getUserEmail()));

		Case mCase = caseRepository.save(Case.builder()
				.id(uniqueIdGen.idGen())
				.status(Status.valueOf(toCreate.getStatus().toUpperCase()))
				.severity(toCreate.getSeverity())
				.title(toCreate.getTitle())
				.description(toCreate.getDescription())
				.user(user)
				.build());
		
		noteService.saveNote(toCreate, mCase);
		
		return mCase;
	}
}
