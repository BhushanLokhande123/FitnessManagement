package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.DietPlan;
import com.example.demo.entities.Login;
import com.example.demo.entities.Member;
import com.example.demo.entities.MemberRegister;
import com.example.demo.repositories.DietPlanRepository;
import com.example.demo.services.LoginServices;
import com.example.demo.services.MemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/controller")
public class MemberController

{
	@Autowired
	MemberService mservice;
	
	@Autowired
	LoginServices lservice;
	
	
	
	/*@GetMapping("/allmembers")
	public List<Member>getAll()
	{
		return mservice.getAllMembers();
	}*/
	
	@PostMapping("/registerm")
	//@RequestMapping(value="fetchMember",consumes={"application/json"}, produces= {"application/json"})
	public Member registerMember(@RequestBody MemberRegister mr)
	{
		System.out.println("inside controller");
		Login l=new Login(mr.getUsername(),mr.getPassword(),"member");
		System.out.println(l.getUsername());
		Login inserted=lservice.add(l);
		Member m=new Member(mr.getFullname(),mr.getGender(),mr.getHeight(),mr.getWeight(),mr.getChest(),mr.getWaist(),mr.getContactno(),mr.getStatus(),mr.getEmail(),inserted,mr.getTid());
		System.out.println(m.getFullname());
		return mservice.add(m);
	}
	
	@PostMapping("/savedm")
	public Member save(@RequestBody Member m)
	{
		System.out.println(m);
		return mservice.save(m);
	}
	
	
	@PostMapping("/fetchDietPlan")
	public List<DietPlan> fetchDietPlan(@RequestParam("category") String category)
	{
		return 	mservice.getDietPlan(category);
	}
}