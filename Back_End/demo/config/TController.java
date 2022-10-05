package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Trainer;
@CrossOrigin
@RestController
public class TController {
	@Autowired
	JdbcTemplate temp;
	@PostMapping("/updatetrainer")
	public String UpdateTrainer(@RequestBody Trainer t) {
		String message="";
		try {
			temp.update("update trainer set fees="+t.getFees()+", workexp="+t.getWorkexp()+", contactno="+t.getContactno()+" where tid="+t.getTid());
			message="Info Updated Successfully";
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="Info Not Updated";
		}
		return message;
	}

}
