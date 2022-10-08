package com.fitness.service;

import java.util.List;

import com.fitness.payloads.UserPageResponse;
import com.fitness.payloads.UserDto;

public interface IUserService {
	
	//create Manager and after successfully created we will assign branch...
	UserDto createManagerUser(UserDto userDto);
	
	//create admin if he want to get enrol then he can assign himself branch...
	UserDto createAdminUser(UserDto userDto);
	
	//create new customer...
	UserDto registerNewCustomer(UserDto userDto);
	
	
	//update user detail...
	UserDto updateUser(UserDto userDto,Integer userId);
	
	//delete
	void deleteUser(Integer userId); //here fetchtype cascade all nhi kr payenge nhi to branch delete...
	
	//get by id 
	UserDto getUserById(Integer userId);
	
	//get all for admin and manager... 
	UserPageResponse getAllUser(Integer pageNumber,Integer pageSize,String sortBy,String sortDir );
	
	//getuserbranch
	List<UserDto> getUserByBranch(Integer branchId);
	
}
