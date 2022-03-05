package com.casesproject.casesproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.enums.Status;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer>{
	List<Case> findAllByStatus(Status status);
	List<Case> findAllByUserId(Integer userId);
	List<Case> findAllByStatusAndUserId(Status status, Integer userId);
}
