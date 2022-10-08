package com.fitness.payloads;

import java.time.LocalDate;
import java.time.Month;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonthlyFitDto {

	private Integer reportId;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Month month;
	
	private LocalDate startDate;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate endDate;
	
	@Min(value = 1, message = "Please Enter a valid Fat %...")
	@NotNull
	private double fat;
	
	@Min(value = 20, message = "Weight is very Low to Join us...")
	@NotNull
	private double weight;
	
	private double muscle;
	
	@Min(value = 50, message = "Height is Very Low to Join Us...")
	private double height;
	
	private UserDto user;
	
}
