package com.fitness.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fitness.eenum.Gender;
import com.fitness.eenum.PaymentStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Email(message = "Email Must Be of proper format")
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String contactNo;

	private String image;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(nullable = false)
	private int age;

	@Column(name = "cust_address")
	private String address;

	@Column(name = "payment_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branch_id")
	private FitnessBranch fitnessBranch;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "package_id")
	private MembershipPackage memberPackage;

	@OneToMany(mappedBy = "userRecord")
	private List<MonthlyFitnessReport> report;

	@ManyToMany(fetch = FetchType.EAGER) // along with user we can store role...
	@JoinTable(name = "user_role", // new table created which has relation between user and its role..
			joinColumns = { @JoinColumn(name = "userId") }, // id of user entity...
			inverseJoinColumns = { @JoinColumn(name = "roleId") }) // id of role																									// entity...
	private List<Role> roles = new ArrayList<Role>();

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Collection of GrantedAuthority is roles so we extract it...
		List<SimpleGrantedAuthority> authorities = this.roles.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		// we will return all authorities which will be used by spring security...
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
