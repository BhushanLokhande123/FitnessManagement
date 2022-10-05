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
import Fitness.FitnessProject.models.AdminRegistration;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	JdbcTemplate temp;
	
	@PostMapping("/registeradmin")
	public String f1(@RequestBody AdminRegistration ar)
	{
		String message="";
		try {
			temp.update("insert into login (email,password,role,username) values (?,?,?,?)",ar.getEmail(),ar.getPassword(),"admin",ar.getUsername());
			int loginid=temp.queryForObject("select loginid from login where username='"+ar.getUsername()+"' and password='"+ar.getPassword()+"'",Integer.class);	
			temp.update("insert into admin (contactno,email,fullname,loginid,status) values (?,?,?,?,?)",ar.getContactno(),ar.getEmail(),ar.getFullname(),loginid,ar.getStatus());
			message="Successfully Added ,Your Login Id :"+loginid;
		} catch (DataAccessException e) {
			message="Username Already exists choose another one";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@PostMapping("/updateadmin")
	public String UpdateAdmin(@RequestBody AdminRegistration ar)
	{
		String message="";
		try {
			temp.update("update admin set email='"+ar.getEmail()+"',contactno="+ar.getContactno()+" where aid="+ar.getAid());
			message="Successfully Update";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@GetMapping("/getalladmin")
	public ArrayList<AdminRegistration> getAllPlan()
	{
		List<AdminRegistration> list=new ArrayList<AdminRegistration>();
		try {
			list=temp.query("select * from admin,login where admin.loginid=login.loginid",(rs,rownum)->{return new AdminRegistration(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(9),rs.getString(10),rs.getString(11));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return (ArrayList<AdminRegistration>) list;
	}
	
	@GetMapping("/getadmin/{id}")
	public AdminRegistration getAllPlan(@PathVariable int id)
	{
		AdminRegistration admin=new AdminRegistration();
		try {
			admin=temp.queryForObject("select * from admin,login where admin.loginid=login.loginid and admin.loginid="+id,(rs,rownum)->{return new AdminRegistration(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(9),rs.getString(10),rs.getString(11));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return admin;
	}

}
