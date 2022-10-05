package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DietPlan;
import com.example.demo.entities.Member;
import com.example.demo.repositories.DietPlanRepository;
import com.example.demo.repositories.MemberRepository;

@Service
public class MemberService 
{
	@Autowired
	MemberRepository mrepo;
	
	@Autowired
	DietPlanRepository dietPlanRepository;
	
	/*public List<Member> getAllMembers()
	{
		return mrepo.findAll();
	}*/
	
	public Member add(Member m) {
		return mrepo.save(m);
	}
	
	public Member save(Member m)
	{
		return mrepo.save(m);
	}

	public 	List<DietPlan> getDietPlan(String category) {
		List<DietPlan> dietPlanList=dietPlanRepository.getByCategory(category);
		return dietPlanList;
	}

	
	
}