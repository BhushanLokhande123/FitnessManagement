
  package com.fitness.service;
  
  import java.time.Month; import java.util.List;
  
  import com.fitness.payloads.MonthlyFitDto;
  
  public interface IMonthlyFitnessService {
  
	  //created by manager... 
	  MonthlyFitDto createFitnessReport(MonthlyFitDto monthlyDto,Integer userId);
  
	  //update by manager... 
	  MonthlyFitDto updateFitnessReport(MonthlyFitDto monthlyDto,Integer userId,Integer reportId);
	  
	  void deleteFitnessReport(Integer userId,Month month);
	  
  }
 