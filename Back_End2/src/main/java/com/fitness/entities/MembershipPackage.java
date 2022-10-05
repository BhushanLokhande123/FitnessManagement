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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="memb_package")
@Getter
@Setter
@NoArgsConstructor
public class MembershipPackage {
//package_id | package_name    | duration | amount | description.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pkg_id")
	private Integer packageId;
	
	@Column(name = "pkg_name",nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int duration;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = true)
	private String description;
	
	@OneToMany(mappedBy = "memberPackage",fetch = FetchType.EAGER)
	private List<User> packge;
	
}
