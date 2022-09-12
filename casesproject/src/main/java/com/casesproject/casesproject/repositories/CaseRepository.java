package com.casesproject.casesproject.repositories;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface CaseRepository extends MongoRepository<Case, Long> {//JpaRepository<Case, Integer>{
	Optional<Case> findById(Long id);
	List<Case> findAllByStatus(Status status);
	List<Case> findAllByUserId(Long userId);
	List<Case> findAllByStatusAndUserId(Status status, Long userId);
}
