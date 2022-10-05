package com.fitness.controller;

import java.time.LocalDateTime;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.config.AppConstants;
import com.fitness.payloads.ApiResponse;
import com.fitness.payloads.BranchPageResponse;
import com.fitness.payloads.FitnessBranchDto;
import com.fitness.payloads.UserDto;
import com.fitness.service.IFitnessBranchService;

@RestController
@RequestMapping("/api/branch")
public class FitnessBranchController {

	@Autowired
	private IFitnessBranchService branchService;
	
	@PostMapping("/")
	
	private ResponseEntity<FitnessBranchDto> createBranch(@Valid @RequestBody FitnessBranchDto branchDto) {
		
		FitnessBranchDto createBranch = this.branchService.createBranch(branchDto);
		
		return new ResponseEntity<FitnessBranchDto>(createBranch,HttpStatus.CREATED);
	}
	
	@PutMapping("/{branchId}")
	
	private ResponseEntity<FitnessBranchDto> updateBranch(@Valid @RequestBody FitnessBranchDto branchDto,
			@PathVariable Integer branchId) {
		
		FitnessBranchDto updateBranch = this.branchService.updateBranch(branchDto, branchId);
		
		return ResponseEntity.ok(updateBranch);
	}
	
	@GetMapping("/{branchId}")
	private ResponseEntity<FitnessBranchDto> getBranchById(@PathVariable Integer branchId) {
		
		FitnessBranchDto getBranch = this.branchService.getBranchById(branchId);
		
		return ResponseEntity.ok(getBranch);
	}
	
	@GetMapping("/")
	private ResponseEntity<BranchPageResponse> getAllBranch(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize, 
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY2, required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		
		BranchPageResponse pageResponse = this.branchService.getAllBranch(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<BranchPageResponse>(pageResponse,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{branchId}")
	private ResponseEntity<ApiResponse> deleteBranchById(@PathVariable Integer branchId) {
		this.branchService.deleteBranch(branchId);
		
		return new ResponseEntity<>(new ApiResponse("Branch With BranchId : "+branchId+" Deleted Successfully...",LocalDateTime.now()),HttpStatus.OK);
	}
	
	@GetMapping("/{branchId}/user/{userId}")
	//ASSIGN (CUSTOMER TO HIMSELF) AND CHANGE(MANAGER) BRANCH...
	private ResponseEntity<UserDto> assignBranchToUser(@PathVariable Integer branchId,
			@PathVariable Integer userId) {
		
		UserDto assignBranchToUser = this.branchService.assignBranchToUser(userId, branchId);
		
		return new ResponseEntity<UserDto>(assignBranchToUser,HttpStatus.OK);
	}
	
}
