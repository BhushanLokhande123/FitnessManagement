package com.fitness.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entities.FitnessBranch;
import com.fitness.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public List<User> findByFitnessBranch(FitnessBranch branch);
	
	//username is email so load data for security...useing this method in security pkg...
	Optional<User> findByEmail(String email);
}
