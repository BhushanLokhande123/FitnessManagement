package com.fitness.repository;

import java.time.Month;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fitness.entities.MonthlyFitnessReport;

public interface MonthlyFitnessRepo extends JpaRepository<MonthlyFitnessReport, Integer> {

//	MonthlyFitnessReport findByMonthAndMemberRecord(Month month,Integer recordId);
//	
//	List<MonthlyFitnessReport> findAllByMemberRecord(Integer recordId);
	
	@Query("DELETE FROM MonthlyFitnessReport m where m.month=:month and m.userRecord=:userId ")
	MonthlyFitnessReport findByMonthAndUserRecord(@Param("month")Month month,@Param("userId")Integer userId);
}
