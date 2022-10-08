package com.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entities.MembershipPackage;

public interface MembPackageRepo extends JpaRepository<MembershipPackage, Integer>{
	

}
