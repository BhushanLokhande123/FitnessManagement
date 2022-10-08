
package com.fitness.service;

import java.time.Month;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.entities.MonthlyFitnessReport;
import com.fitness.entities.User;
import com.fitness.exceptions.ResourceNotFoundException;
import com.fitness.payloads.MonthlyFitDto;
import com.fitness.repository.MonthlyFitnessRepo;
import com.fitness.repository.UserRepo;

@Service
public class MonthlyFitnessReportImpl implements IMonthlyFitnessService {

	@Autowired
	private MonthlyFitnessRepo fitnessRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Override
	public MonthlyFitDto createFitnessReport(MonthlyFitDto monthlyDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		

		Integer duration = user.getMemberPackage().getDuration();

		MonthlyFitnessReport monthlyFitnessReport = this.modelMapper.map(monthlyDto, MonthlyFitnessReport.class);

		monthlyFitnessReport.setStartDate(monthlyDto.getStartDate());
		monthlyFitnessReport.setEndDate(monthlyDto.getStartDate().plusMonths(duration));

		monthlyFitnessReport.setMonth(monthlyDto.getMonth());
		monthlyFitnessReport.setFat(monthlyDto.getFat());
		monthlyFitnessReport.setHeight(monthlyDto.getHeight());
		monthlyFitnessReport.setMuscle(monthlyDto.getMuscle());
		monthlyFitnessReport.setWeight(monthlyDto.getWeight());

		monthlyFitnessReport.setUserRecord(user);

		MonthlyFitnessReport fitnessReport = this.fitnessRepo.save(monthlyFitnessReport);

		return this.modelMapper.map(fitnessReport, MonthlyFitDto.class);

	}

	@Override
	public MonthlyFitDto updateFitnessReport(MonthlyFitDto monthlyDto, Integer userId,Integer reportId) {

		MonthlyFitnessReport monthlyFitnessReport = this.fitnessRepo.findById(reportId).orElseThrow(()-> new 
				ResourceNotFoundException("Report", "Report Id", reportId));
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

		Integer duration = user.getMemberPackage().getDuration();

		monthlyFitnessReport.setStartDate(monthlyDto.getStartDate());
		monthlyFitnessReport.setEndDate(monthlyDto.getEndDate());

		monthlyFitnessReport.setMonth(monthlyDto.getMonth());
		monthlyFitnessReport.setFat(monthlyDto.getFat());
		monthlyFitnessReport.setHeight(monthlyDto.getHeight());
		monthlyFitnessReport.setMuscle(monthlyDto.getMuscle());
		monthlyFitnessReport.setWeight(monthlyDto.getWeight());

		MonthlyFitnessReport save = this.fitnessRepo.save(monthlyFitnessReport);

		return this.modelMapper.map(save, MonthlyFitDto.class);

	}

	@Override
	public void deleteFitnessReport(Integer userId, Month month) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		
		MonthlyFitnessReport findByMonthAndUserRecord = this.fitnessRepo.findByMonthAndUserRecord(month, userId);
		
		this.fitnessRepo.delete(findByMonthAndUserRecord);
		
		System.out.println("Report deleted with userId "+userId+" Month deleted successfully...");
		
	}

}
