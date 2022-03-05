package com.casesproject.casesproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casesproject.casesproject.domain.Note;
import com.casesproject.casesproject.services.NoteService;

@RestController
@RequestMapping("/api")
public class NoteResource {
	private final NoteService noteService;

	public NoteResource(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
	public ResponseEntity<Note> addNote(@PathVariable Integer caseId, @RequestBody String detail) {
		Note note = noteService.addNoteByCaseId(caseId, detail);
		return new ResponseEntity<Note>(note, HttpStatus.CREATED);
	}

}
