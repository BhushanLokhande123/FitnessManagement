package com.fitness.security;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.fitness.entities.User;
import com.fitness.exceptions.UserNotFoundExceptionByEmail;
import com.fitness.repository.UserRepo;

//db authentication loads user by username will call method...

@Service
public class CustomeUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from db by username...
		
		User user = this.userRepo.findByEmail(username).
		orElseThrow(()->new UserNotFoundExceptionByEmail("User", "email", username));
		
		return user;
	}
	
	
}
