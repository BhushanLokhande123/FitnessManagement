package com.fitness.service;

import java.util.List;

import com.fitness.payloads.MemberPackageDto;
import com.fitness.payloads.PackagePageResponse;
import com.fitness.payloads.UserDto;


public interface IMembPackageService {

	//create
	MemberPackageDto createPackage(MemberPackageDto membPackageDto);
	
	//update
	MemberPackageDto updatePackage(MemberPackageDto membPackageDto,Integer packageId);
	
	//delete
	void deletePackage(Integer packageId);
	
	//getbyid
	MemberPackageDto getPackageById(Integer packageId);
	
	//getall
	PackagePageResponse getAllPackage(Integer pageNumber,Integer pageSize,String sortBy,String sortDir );
	
	UserDto assignPackageToUser(Integer userId,Integer packageId);
	
}
