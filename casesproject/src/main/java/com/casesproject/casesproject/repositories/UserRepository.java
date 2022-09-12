package com.casesproject.casesproject.repositories;

import com.casesproject.casesproject.domain.Case;
import com.casesproject.casesproject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Repository
public interface UserRepository extends MongoRepository<User, Long> { //JpaRepository<User, Integer> {
	Optional<User> findUserByEmail(String email);
}
