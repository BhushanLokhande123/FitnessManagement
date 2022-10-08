package com.fitness.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.fitness.config.AppConstants;
import com.fitness.payloads.ApiResponse;
import com.fitness.payloads.UserPageResponse;
import com.fitness.payloads.UserDto;
import com.fitness.service.IFileService;
import com.fitness.service.IFitnessBranchService;
import com.fitness.service.IUserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IFitnessBranchService fitBranchService;
	
//  create user (manager,trainer,customer,admin) and after 
//	successfully created we will assign branch...
	
	@Autowired 
	private IFileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PutMapping("/{userId}")
	private ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable Integer userId) {
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{userId}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		ApiResponse apiresp = new ApiResponse("User with "+userId+" Deleted successfully...,"
				,LocalDateTime.now());
		
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.OK);
	}
	
	
	@GetMapping("/{userId}")
	private ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
		
		UserDto userById = this.userService.getUserById(userId);
		
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	private ResponseEntity<UserPageResponse> getAllUser(
		@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
		@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize, 
		@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
		@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		
		UserPageResponse postResponse = this.userService.getAllUser(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<UserPageResponse>(postResponse,HttpStatus.OK);
	}
	
	
	@PostMapping("/image/upload/{userId}")
	public ResponseEntity<UserDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer userId) throws IOException 
	{
		UserDto userDto = this.userService.getUserById(userId);
		//image uploaded to folder...
		String fileName = this.fileService.uploadImage(path, image);
		
		userDto.setImage(fileName);//name of image sent to db...
		
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response) throws IOException {
		
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		
	}
}
