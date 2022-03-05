package com.casesproject.casesproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casesproject.casesproject.domain.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
