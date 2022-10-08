package com.fitness.service;

import java.util.List;

import com.fitness.payloads.BranchPageResponse;
import com.fitness.payloads.FitnessBranchDto;
import com.fitness.payloads.UserPageResponse;
import com.fitness.payloads.UserDto;

public interface IFitnessBranchService {
	
	//create
	FitnessBranchDto createBranch(FitnessBranchDto branchDto);
	
	//update
	FitnessBranchDto updateBranch(FitnessBranchDto branchDto, Integer branchId);
	
	//delete
	void deleteBranch(Integer branchId);
	
	//findbyid
	
	FitnessBranchDto getBranchById(Integer branchId);
	
	//findall
	BranchPageResponse getAllBranch(Integer pageNumber,Integer pageSize,String sortBy,String sortDir );
	
	//assign/change branch to customer/manager same method... 
	UserDto assignBranchToUser(Integer userId,Integer branchId);
	
}
