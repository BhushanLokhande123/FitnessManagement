package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entities.Login;
import com.example.demo.entities.Member;
import com.example.demo.entities.Trainer;
import com.example.demo.repositories.LoginRepository;
import com.example.demo.repositories.MemberRepository;
import com.example.demo.repositories.TrainerRepository;


import java.util.Optional;

@Service
public class LoginServices {
	
	@Autowired
	LoginRepository lrepo;
	@Autowired
	MemberRepository mrepo;
	@Autowired
	TrainerRepository trepo;
	
	/*public String checkLogin(String username,String password)
	  {
		return lrepo.checkLogin(username, password);	
	   }*/

	public Login add(Login l)
	{
		return lrepo.save(l); //insert record in login table
	}
	
	public Object checkLogin(String username,String password)
	{
		List<Login> l= lrepo.checkLogin(username, password);
		System.out.println( " List size : "+l.size());
		l.forEach(data-> System.out.println("id : "+data.getLoginid()+" role: "+data.getRole()+" username: "+data.getUsername()));
		if(l.size()==1)
		{
		//System.out.println(l.get(0)[0]+" : "+l.get(0)[1]);
		Member m=null;
		Trainer t=null;
		for(Login lObj :l)
		{
		   if((lObj.getRole().equalsIgnoreCase("member") || (lObj.getRole().equalsIgnoreCase("admin")) ))
		     {
			    //Optional<Member> om = mrepo.findById((int)l.get(0)[1]);
		      	Optional<Member> om = mrepo.checkMember(lObj);
			    try
			    {
				   return om;
			    }
			    catch(Exception e)
			    {
				   e.printStackTrace();
			    }
		     }
		   
		   else if((lObj.getRole().equalsIgnoreCase("trainer")))
		     {
			    //Optional<Member> om = mrepo.findById((int)l.get(0)[1]);
		      	Optional<Trainer> ot = trepo.checkTrainer(lObj);
			    try
			    {
				   return ot;
			    }
			    catch(Exception e)
			    {
				   e.printStackTrace();
			    }
		     }
		}
		return m;

		}
		else
		{
			return null;
		}
	}
}
