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

import Fitness.FitnessProject.models.Payment;

@CrossOrigin
@RestController
public class PaymentController {
	
	@Autowired
	JdbcTemplate temp;
	
	@PostMapping("/payment")
	public String doPayment(@RequestBody Payment payment)
	{
		String message="";
		try {
			temp.update("insert into payment (fees,name,loginid) values (?,?,?)",payment.getFees(),payment.getName(),payment.getLoginid());
			message="Successfully Added";
		} catch (DataAccessException e) {
			message="Query Failed";
			e.printStackTrace();
		}		
		return message;	
	}
	
	@GetMapping("/getpayment/{id}")
	public Payment getPayment(@PathVariable int id)
	{
		Payment pm=null;
		try {
			pm = temp.queryForObject("select * from payment where loginid="+id,(rs,rownum)->{return new Payment(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getInt(4));});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}		
		return pm;	
	}
	

	@GetMapping("/getpaymentdetails")
	public ArrayList<Payment> getPaymentDetails()
	{
			List<Payment> pm=null;
			try {
				pm = temp.query("select * from payment",(rs,rownum)->{return new Payment(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getInt(4));});
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
	
		return (ArrayList<Payment>) pm;	
	}
}
