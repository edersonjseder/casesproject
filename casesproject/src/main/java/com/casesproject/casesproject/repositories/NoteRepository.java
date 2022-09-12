package com.casesproject.casesproject.repositories;

import com.casesproject.casesproject.domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface NoteRepository extends MongoRepository<Note, Long> { //JpaRepository<Note, Integer>{

}
