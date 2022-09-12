package com.casesproject.casesproject.services;

import com.casesproject.casesproject.repositories.dto.CaseDto;
import com.casesproject.casesproject.utils.UniqueIdGen;
import org.springframework.stereotype.Service;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.domain.Note;
import com.casesproject.casesproject.exceptions.ResourceNotFoundException;
import com.casesproject.casesproject.repositories.CaseRepository;
import com.casesproject.casesproject.repositories.NoteRepository;

@Service
public class NoteService {
	private final NoteRepository noteRepository;
	private final CaseRepository caseRepository;

	public NoteService(NoteRepository noteRepository,
					   CaseRepository caseRepository) {
		this.noteRepository = noteRepository;
		this.caseRepository = caseRepository;
	}
	
	public Note addNoteByCaseId(Long caseId, String detail) {
		Case mCase = new Case();
		try {
			mCase = caseRepository.findById(caseId)
					.orElseThrow(() -> new ResourceNotFoundException("Case not found with Id: " + caseId));
		} catch (ResourceNotFoundException e) {
			mCase = null;
		}
		
		return noteRepository.save(Note.builder().details(detail).mCase(mCase).build());
	}

	public void saveNote(CaseDto caseDto, Case mCase) {
		var uniqueIdGen = new UniqueIdGen();
		noteRepository.save(Note.builder().id(uniqueIdGen.idGen()).details(caseDto.getNoteDetail()).mCase(mCase).build());
	}
}
