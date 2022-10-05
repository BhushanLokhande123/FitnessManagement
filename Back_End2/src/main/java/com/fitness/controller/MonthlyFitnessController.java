
package com.fitness.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.payloads.ApiResponse;
import com.fitness.payloads.MonthlyFitDto;
import com.fitness.service.IMonthlyFitnessService;

@RestController

@RequestMapping("/api/report")
public class MonthlyFitnessController {

	@Autowired
	private IMonthlyFitnessService monthlyFitnessService;
	

	@PostMapping("/user/{userId}")
	private ResponseEntity<MonthlyFitDto> createReport(@RequestBody @Valid MonthlyFitDto monthlyDto,
				@PathVariable Integer userId) {

		MonthlyFitDto createFitnessReport = this.monthlyFitnessService.createFitnessReport(monthlyDto, userId);

		return new ResponseEntity<MonthlyFitDto>(createFitnessReport, HttpStatus.CREATED);

	}

	@PutMapping("/{reportId}/user/{userId}")
	private ResponseEntity<MonthlyFitDto> updateReport(@RequestBody @Valid MonthlyFitDto monthlyDto,
			@PathVariable Integer reportId,@PathVariable Integer userId) {

		MonthlyFitDto updateFitnessReport = this.monthlyFitnessService.updateFitnessReport(monthlyDto,userId,reportId);
		return new ResponseEntity<MonthlyFitDto>(updateFitnessReport, HttpStatus.IM_USED);
	}

	@DeleteMapping("{month}/user/{userId}")
	private ResponseEntity<ApiResponse> deleteFitnessReportByMonthAndUserId(
			@PathVariable Integer userId,@PathVariable Month month) {
		
//		Month month1 = Month.valueOf(month);
		
		this.monthlyFitnessService.deleteFitnessReport(userId, month);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Report Deleted succefully",
				LocalDateTime.now()),HttpStatus.OK);
		
		
	}
//	@DeleteMapping("/{reportId}")
//	private ResponseEntity<ApiResponse> deleteReport(@PathVariable Integer repordId) {
//		this.monthlyFitnessService.deleteMonthlyFitnessReport(repordId);
//
//		return new ResponseEntity<ApiResponse>(new ApiResponse("Report deleted successfully..", LocalDateTime.now()),
//				HttpStatus.OK);
//	}
//
//	@GetMapping("/record/{recordId}/month/{month}")
//	private ResponseEntity<MonthlyFitDto> getReportByMonthAndRecordId(@PathVariable Month month,
//
//			@PathVariable Integer recordId) {
//
//		MonthlyFitDto monthlyFitnessReportByMonthAndId = this.monthlyFitnessService
//				.getMonthlyFitnessReportByMonthAndId(month, recordId);
//
//		return new ResponseEntity<MonthlyFitDto>(monthlyFitnessReportByMonthAndId, HttpStatus.OK);
//
//	}
//
//	@GetMapping("/record/{recordId}")
//	private ResponseEntity<List<MonthlyFitDto>> getReportsByRecordId(@PathVariable Integer recordId) {
//
//		List<MonthlyFitDto> allReportsByRecordId = this.monthlyFitnessService.getAllReportsByRecordId(recordId);
//
//		return new ResponseEntity<List<MonthlyFitDto>>(allReportsByRecordId, HttpStatus.OK);
//	}
}
