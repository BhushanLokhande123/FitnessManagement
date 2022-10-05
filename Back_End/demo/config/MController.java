package com.example.demo.config;

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

import com.example.demo.entities.Member;
@CrossOrigin
@RestController
public class MController {
	@Autowired
	JdbcTemplate temp;
	@PostMapping("/updatemember")
	public String UpdateMember(@RequestBody Member m) {
		String message="";
		try {
			
			temp.update("update member set chest="+m.getChest()+", height="+m.getHeight()+", waist="+m.getWaist()+", weight="+m.getWeight()+" where memid="+m.getMemid());
             message ="Successfully Updated";
			
		} catch (Exception e) {
			// TODO: handle exception
			message="Info Not Updated";
		}
		return message;
	}
	@GetMapping("/getmember/{id}")
	public ArrayList<Member> getAllmember(@PathVariable int id){
//		String fullname, double height, double weight, double chest, double waist, String contactno,
//		int tid
	List<Member> list=new ArrayList<>();
	try {
		list = temp.query("select * from member where tid="+id,(rs,rownum)->{return new Member(rs.getString(5),rs.getDouble(7),rs.getDouble(11),rs.getDouble(2),rs.getDouble(10),rs.getString(3),rs.getInt(9));});
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return (ArrayList<Member>) list;
	}

}
