package com.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entities.FitnessBranch;

public interface FitnessBranchRepo extends JpaRepository<FitnessBranch, Integer> {
	
	

}
