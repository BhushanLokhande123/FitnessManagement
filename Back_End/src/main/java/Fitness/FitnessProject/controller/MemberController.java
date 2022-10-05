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

import Fitness.FitnessProject.models.MemberRegister;

@RestController
@CrossOrigin
public class MemberController {
	@Autowired
	JdbcTemplate temp;
	
	@PostMapping("/registermember")
	public String f1(@RequestBody MemberRegister mr)
	{
		String message="";
		try {
			temp.update("insert into login (email,password,role,username) values (?,?,?,?)",mr.getEmail(),mr.getPassword(),"member",mr.getUsername());
			int loginid=temp.queryForObject("select loginid from login where username='"+mr.getUsername()+"' and password='"+mr.getPassword()+"'",Integer.class);	
			temp.update("insert into member (chest,contactno,email,fullname,gender,height,injury,status,tid,waist,weight,loginid) values (?,?,?,?,?,?,?,?,?,?,?,?)",mr.getChest(),mr.getContactno(),mr.getEmail(),mr.getFullname(),mr.getGender(),mr.getHeight(),mr.getInjury(),mr.getStatus(),mr.getTid(),mr.getWaist(),mr.getWeight(),loginid);
			temp.update("insert into payment(name,fees,loginid) values(?,?,?)",mr.getFullname(),mr.getFees(),loginid);
			message="Successfully Added ,Your Login Id :"+loginid;
			temp.update("insert into diet_plan(id) values (?)",loginid);
			temp.update("insert into workout_plan(id) values (?)",loginid);

		} catch (DataAccessException e) {
			message="Username Already exists choose another one";
			e.printStackTrace();
		}		
		return message;	
	}
	@PostMapping("/updatemember")
	public String UpdateMember(@RequestBody MemberRegister mr)
	{
		String message="";
		try {
			temp.update("update member set chest='"+mr.getChest()+"', waist='"+mr.getWaist()+"',weight='"+mr.getWeight()+"',height='"+mr.getHeight()+"',contactno='"+mr.getContactno()+"',injury='"+mr.getInjury()+"',email='"+mr.getEmail()+"' where memid ="+mr.getMemid());
			message="Successfully Updated";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@PostMapping("/adminupdatemember")
	public String AdminUpdateMember(@RequestBody MemberRegister mr)
	{
		String message="";
		try {
			temp.update("update member set chest='"+mr.getChest()+"', waist='"+mr.getWaist()+"',weight='"+mr.getWeight()+"',height='"+mr.getHeight()+"',contactno='"+mr.getContactno()+"',injury='"+mr.getInjury()+"',email='"+mr.getEmail()+"',fullname='"+mr.getFullname()+"',status='"+mr.getStatus()+"',gender='"+mr.getGender()+"',tid="+mr.getTid()+" where memid ="+mr.getMemid());
			message="Successfully Updated";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@GetMapping("/getallmember")
	public ArrayList<MemberRegister> getAllMember()
	{
		List<MemberRegister> list=new ArrayList<MemberRegister>();
		
		try {
			list=temp.query("select * from member",(rs,rownum)->{return new MemberRegister(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getDouble(11),rs.getDouble(12),rs.getInt(13));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return (ArrayList<MemberRegister>) list;
	}
	
	
	@GetMapping("/getmember/{id}")
	public MemberRegister getMember(@PathVariable int id)
	{
		MemberRegister member=new MemberRegister();
		
		try {
			member=temp.queryForObject("select * from member,login where member.loginid=login.loginid and member.loginid="+id,(rs,rownum)->{return new MemberRegister(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getDouble(11),rs.getDouble(12),rs.getInt(13),rs.getString(16),rs.getString(17),rs.getString(18));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	@GetMapping("/getallmemberbytrainerid/{tid}")
	public ArrayList<MemberRegister> getAllMemberByTrainerId(@PathVariable int tid)
	{
		List<MemberRegister> list=new ArrayList<MemberRegister>();
		
		try {
			list=temp.query("select * from member where tid="+tid,(rs,rownum)->{return new MemberRegister(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getDouble(11),rs.getDouble(12),rs.getInt(13));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return (ArrayList<MemberRegister>) list;
	}
	
	
}
