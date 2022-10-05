package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.Trainer;
import com.example.demo.entities.TrainerRegister;
import com.example.demo.services.LoginServices;
import com.example.demo.services.TrainerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/controller")
public class TrainerController

{
	@Autowired
	TrainerService tservice;
	
	@Autowired
	LoginServices lservice;
	
	/*@GetMapping("/alltrainers")
	public List<Trainer>getAll()
	{
		return tservice.getAllTrainers();
	}*/
	
	@PostMapping("/registert")
//	@RequestMapping(value="fetchMember",consumes={"application/json"}, produces= {"application/json"})
	public Trainer registerTrainer(@RequestBody TrainerRegister tr)
	{
		System.out.println("inside controller");
		Login l=new Login(tr.getUsername(),tr.getPassword(),"trainer");
		System.out.println(l.getUsername());
		Login inserted=lservice.add(l);
		Trainer t=new Trainer(tr.getFullname(),tr.getFees(),tr.getEmail(),tr.getSpeciality(),tr.getWorkexp(),tr.getStatus(),tr.getContactno(),inserted);
		System.out.println(tr.getFullname());
		return tservice.add(t);
	}
	
	@PostMapping("/savedt")
	public Trainer save(@RequestBody Trainer t)
	{
		System.out.println(t);
		return tservice.save(t);
	}
	
	@PostMapping("/fetchTrainer")
	public List<Trainer> fetchTrainer (@RequestParam("category") String category)
	{
		List<Trainer> trainerList=new ArrayList<>();
		trainerList=tservice.fetchTrainerDetails(category);
		return trainerList;
		
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam ("workoutPlan") String workoutPlan) throws IOException
	{
		
		//String filename = "D:/natasamticket.pdf";
		String filename="";
		if(workoutPlan.equalsIgnoreCase("yoga"))
		{
		 filename = "D:/cdac/React/Yoga.pdf";
		}
		else if(workoutPlan.equalsIgnoreCase("weightGain"))
		{
			 filename = "D:/cdac/React/WeightGain.pdf";
			}
		else if(workoutPlan.equalsIgnoreCase("weightLoss"))
		{
			 filename = "D:/cdac/React/WeightLoss.pdf";
			}
		
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
}
