package Fitness.FitnessProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Fitness.FitnessProject.models.TrainerRegister;

@CrossOrigin
@RestController
public class TrainerController {
	
	@Autowired
	JdbcTemplate temp;
	
	@PostMapping("/registertrainer")
	public String f1(@RequestBody TrainerRegister tr)
	{
		String message="";
		try {
			temp.update("insert into login (email,password,role,username) values (?,?,?,?)",tr.getEmail(),tr.getPassword(),"trainer",tr.getUsername());
			int loginid=temp.queryForObject("select loginid from login where username='"+tr.getUsername()+"' and password='"+tr.getPassword()+"'",Integer.class);	
			temp.update("insert into trainer (contactno,email,fees,fullname,speciality,status,workexp,loginid) values (?,?,?,?,?,?,?,?)",tr.getContactno(),tr.getEmail(),tr.getFees(),tr.getFullname(),tr.getSpeciality(),tr.getStatus(),tr.getWorkexp(),loginid);
			message="Successfully Added ,Your Login Id :"+loginid;
		} catch (DataAccessException e) {
			message="Username Already exists choose another one";
			e.printStackTrace();
		}		
		return message;	
	}
   
	@PostMapping("/updatetrainer")
	public String UpdateTrainer(@RequestBody TrainerRegister tr)
	{
		String message="";
		try {
			temp.update("update trainer set contactno="+tr.getContactno()+",fees="+tr.getFees()+",workexp="+tr.getWorkexp()+",speciality='"+tr.getSpeciality()+"',email='"+tr.getEmail()+"' where tid ="+tr.getTid());
			message="Successfully Update";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@PostMapping("/adminupdatetrainer")
	public String AdminUpdateTrainer(@RequestBody TrainerRegister tr)
	{
		String message="";
		try {
			temp.update("update trainer set contactno="+tr.getContactno()+",fees="+tr.getFees()+",workexp="+tr.getWorkexp()+",speciality='"+tr.getSpeciality()+"',email='"+tr.getEmail()+"',fullname='"+tr.getFullname()+"',status='"+tr.getStatus()+"'  where tid ="+tr.getTid());
			message="Successfully Update";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@GetMapping("/getalltrainer")
	public ArrayList<TrainerRegister> getAllTrainer()
	{
		List<TrainerRegister> list=new ArrayList<TrainerRegister>();
		
		try {
			list=temp.query("select * from trainer",(rs,rownum)->{return new TrainerRegister(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return (ArrayList<TrainerRegister>) list;
	}

	@GetMapping("/getallactivetrainer")
	public ArrayList<TrainerRegister> getAllTrainerbyactive()
	{
		List<TrainerRegister> list=new ArrayList<TrainerRegister>();
		
		try {
			list=temp.query("select * from trainer where status='active'",(rs,rownum)->{return new TrainerRegister(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return (ArrayList<TrainerRegister>) list;
	}
	
	@GetMapping("/gettrainer/{id}")
	public TrainerRegister getTrainer(@PathVariable int id)
	{
		TrainerRegister trainer=new TrainerRegister();
		
		try {
			trainer=temp.queryForObject("select * from trainer,login where trainer.loginid=login.loginid and trainer.loginid="+id ,(rs,rownum)->{return new TrainerRegister(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(12),rs.getString(13),rs.getString(14));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return trainer;
	}


}
