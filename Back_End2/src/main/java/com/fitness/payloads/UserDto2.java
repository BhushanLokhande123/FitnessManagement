package com.fitness.payloads;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fitness.eenum.Gender;
import com.fitness.entities.MembershipPackage;
import com.fitness.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto2 {

	private Integer id;
	
	@NotEmpty(message = "UserName is must...")
	private String name;

	@NotEmpty(message = "Email is Must")
	@Email(message = "Please Enter proper email address") 
	private String email;
	
	@NotEmpty
	@Size(min = 7, max = 50,message = "Weak password,it must be of atleast 7 characters...")
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$",message = ""
			+ "Password must contains 8 characters")
	private String password;
	
	@NotEmpty
	@Size(min = 10,max = 14,message = "ContactNo must be between 10 to 14 characters...")
	private String contactNo;
	
	@NotEmpty(message = "Please Upload Image...")
	private String image;
	
	private Gender gender;
	
	private int age;
	
	private String address;
	
	private List<Role> roles;
	
	private MemberPackageDto packages;
	
	private FitnessBranchDto branch;

	
}