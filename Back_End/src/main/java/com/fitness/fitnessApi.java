package com.fitness;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fitness.config.AppConstants;
import com.fitness.eenum.Gender;
import com.fitness.entities.Role;
import com.fitness.entities.User;
import com.fitness.repository.RoleRepo;
import com.fitness.repository.UserRepo;

@SpringBootApplication
public class fitnessApi implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(fitnessApi.class, args);
	}

	// we can declare bean here as springbootApplication annoted class is
	// configuration class..

	@Bean // sc will create its object will provide bean when we autowired it...
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println(this.passwordEncoder.encode("Bhushan@123"));

		try {
			Role role1 = new Role();
			role1.setId(AppConstants.ROLE_ADMIN);
			role1.setName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setId(AppConstants.ROLE_MANAGER);
			role2.setName("ROLE_MANAGER");
			
			Role role = new Role();
			role.setId(AppConstants.ROLE_CUSTOMER);
			role.setName("ROLE_CUSTOMER");


			List<Role> listRole = List.of(role, role1, role2);

			List<Role> list = this.roleRepo.saveAll(listRole);

			list.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			System.out.println("Roles Does not Loaded...");
		}
		
		
//		try {
//			User user = new User();
//			user.setAddress("Chandrapur");
//			user.setAge(25);
//			user.setContactNo("9876567889");
//			user.setEmail("bhushan@gmail.com");
//			user.setGender(Gender.MALE);
//			user.setImage("Default.png");
//			user.setName("Bhushan Lokhande");
//			user.setPassword(this.passwordEncoder.encode("Bhushan@123"));
//			
//			Role role3 = new Role();
//			role3.setId(AppConstants.ADMIN);
//			role3.setName("ADMIN");
//			
//			List<Role> adminRole = new ArrayList<Role>();
//			adminRole.add(role3);
//			
//			user.setRoles(adminRole);
//			
//			User save = this.userRepo.save(user);
//			
//		}catch (Exception e) {
//			System.out.println("Admin Not Registered yet");
//		}
//	ONCE APPLICATION STARTS FOR FIRST TIME ONLY THAT TIME THIS ROLES GETS STORED IN DB...
//		AS WE DONT HAVE ID OF ROLE ENTITY TO BE AUTOINCREMENTED...
	}
}
