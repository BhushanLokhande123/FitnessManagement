package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Login;
import com.example.demo.services.LoginServices;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class LoginController {
	
	@Autowired
	LoginServices lservice;
	
	/*@GetMapping("/checklogin")
	public String checkLogin (@RequestParam("username")String username,@RequestParam("password")String password) {
		return lservice.checkLogin(username, password);
	}*/
	
	@PostMapping("/checkLogin")
	public Object checkLogin(@RequestBody Login l) 
	{
		return lservice.checkLogin(l.getUsername(),l.getPassword());
	}

}
