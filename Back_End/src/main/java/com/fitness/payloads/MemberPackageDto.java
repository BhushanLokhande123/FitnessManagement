package com.fitness.payloads;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberPackageDto {
	
	private Integer packageId;
	
	@NotEmpty(message = "Package Name Must Be Inserted...")
	private String name;
	
	@Min(1)
	@Max(12)
	private int duration;
	
	@Min(1)
	private double amount;
	
	@NotBlank(message = "Description Cannt be kept Blank...")
	private String description;

}
