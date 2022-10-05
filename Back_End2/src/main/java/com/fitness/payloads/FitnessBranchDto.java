package com.fitness.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FitnessBranchDto {

	private Integer branchId;
	
	@NotEmpty(message = "Please Enter Name...")
	private String name;
	
	@NotBlank(message = "Branch Information cannt be kept Blank...")
	private String info;
	
	@NotEmpty
	@Size(min = 10,max = 14,message = "ContactNo must be between 10 to 14 characters...")
	private String contact;
	
	@NotEmpty(message = "Please Enter Proper Address...")
	private String address;

}
