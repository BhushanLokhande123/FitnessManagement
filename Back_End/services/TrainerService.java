package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Member;
import com.example.demo.entities.Trainer;
import com.example.demo.repositories.TrainerRepository;

@Service
public class TrainerService 
{
	@Autowired
	TrainerRepository trepo;
	
	/*public List<Member> getAllTrainers()
	{
		return trepo.findAll();
	}*/
	
	public Trainer save(Trainer t)
	{
		return trepo.save(t); //insert record in mamber table
	}
	
	public Trainer add(Trainer t) {
		return trepo.save(t);
	}

	public List<Trainer> fetchTrainerDetails(String category) {
		// TODO Auto-generated method stub
		List<Trainer> trainerList=trepo.getTrainerDetail(category);
		trainerList.forEach(data->System.out.println(data.getFullname()+data.getSpeciality()));
		return trainerList;
	}
	
}