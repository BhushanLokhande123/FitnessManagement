package com.fitness.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="fitness_branch")
@Getter
@Setter
@NoArgsConstructor
public class FitnessBranch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branch_id")
	private Integer branchId;
	
	@Column(name="branch_name" ,nullable = false)
	private String name;
	
	@Column(name="branch_info" ,nullable = false)
	private String info;
	
	@Column(nullable = false)
	private String contact;
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany(mappedBy = "fitnessBranch",fetch = FetchType.EAGER)
	private List<User> user;
	
}
