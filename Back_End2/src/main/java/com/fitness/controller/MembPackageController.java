package com.fitness.controller;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.config.AppConstants;
import com.fitness.payloads.ApiResponse;
import com.fitness.payloads.MemberPackageDto;
import com.fitness.payloads.PackagePageResponse;
import com.fitness.payloads.UserDto;
import com.fitness.service.IMembPackageService;
import com.fitness.service.MembPackageServiceImpl;

@RestController
@RequestMapping("/api/package")
public class MembPackageController {
	
	@Autowired
	private IMembPackageService membPackageService;
	
	@PostMapping("/")
	private ResponseEntity<MemberPackageDto> createPackage(@Valid @RequestBody MemberPackageDto membPackDto) {
		MemberPackageDto createPackage = this.membPackageService.createPackage(membPackDto);
		return new ResponseEntity<MemberPackageDto>(createPackage,HttpStatus.CREATED);
	}
	
	@PutMapping("/{packageId}")
	private ResponseEntity<MemberPackageDto> updatePackage(@Valid @RequestBody MemberPackageDto membPackDto,
			@PathVariable Integer packageId) {
		MemberPackageDto updatePackage = this.membPackageService.updatePackage(membPackDto, packageId);
		return ResponseEntity.ok(updatePackage);
	}
	
	@DeleteMapping("/{packageId}")
	private ResponseEntity<ApiResponse> deletePackage(@PathVariable Integer packageId){
		
		this.membPackageService.deletePackage(packageId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Package with : "+packageId+" deleted successfully..."
				,LocalDateTime.now()),HttpStatus.OK);
	}
	
	@GetMapping("/{packageId}")
	private ResponseEntity<MemberPackageDto> getPackageById(@PathVariable Integer packageId) {
		MemberPackageDto packageById = this.membPackageService.getPackageById(packageId);
		return new ResponseEntity<MemberPackageDto>(packageById,HttpStatus.OK);
	}
	
	@GetMapping("/")
	private ResponseEntity<PackagePageResponse> getAllPackage(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize, 
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY1, required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		
		PackagePageResponse allPackage = this.membPackageService.getAllPackage(pageNumber,pageSize,sortBy,sortDir);
		
		return ResponseEntity.ok(allPackage);
	}
	
	@GetMapping("/{packageId}/user/{userId}")
	private ResponseEntity<UserDto> assignPackageToUser(@PathVariable Integer userId,
			@PathVariable Integer packageId){
		
		UserDto packageToUser = this.membPackageService.assignPackageToUser(userId, packageId);
		
		return new ResponseEntity<UserDto>(packageToUser,HttpStatus.OK);
	}
	
}
