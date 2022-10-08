package com.fitness.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.entities.User;
import com.fitness.exceptions.ApiException;
import com.fitness.payloads.JwtAuthRequest;
import com.fitness.payloads.JwtAuthResponse;
import com.fitness.payloads.UserDto;
import com.fitness.payloads.UserDto2;
import com.fitness.security.JwtTokenHelper;
import com.fitness.service.IUserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		this.authenticate(request.getUsername(), request.getPassword());

		UserDetails userDetail = this.userDetailsService.loadUserByUsername(request.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetail);

		JwtAuthResponse response = new JwtAuthResponse();     
		
	
	
		response.setToken(token);
		
//		response.setUser(this.modelMapper.map((User)userDetail,UserDto.class));
//		response.setUser(this.modelMapper.map((User) userDetail, UserDto2.class));
		response.setUser(this.modelMapper.map((User) userDetail , UserDto2.class));

		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
		
	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(username,password);

		try {
			this.authenticationManager.authenticate(authenticationToken);
		}
		catch (BadCredentialsException e) {
			System.out.println("Invalid Details");
			throw new ApiException("Invalid Username and password !!");
		}

	}
	
	//REGISTER NEW USER API...
	
	@PostMapping("/customer")
	public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto) {
		
		UserDto registerNewUser = this.userService.registerNewCustomer(userDto);
		
		return new ResponseEntity<UserDto>(registerNewUser,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/manager")
	private ResponseEntity<UserDto> createManager(@RequestBody @Valid UserDto userdto) {
		
		UserDto createNormalUser = this.userService.createManagerUser(userdto);
		
		return new ResponseEntity<UserDto>(createNormalUser,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/admin")
	private ResponseEntity<UserDto> createAdmin(@RequestBody @Valid UserDto userDto) {
		
		UserDto createNormalUser = this.userService.createAdminUser(userDto);
		
		return new ResponseEntity<UserDto>(createNormalUser,HttpStatus.CREATED);
	}
}
