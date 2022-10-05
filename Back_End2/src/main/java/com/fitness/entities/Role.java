package com.fitness.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role {

	@Id
	@Column(unique = true)
	private Integer id;
	
	private String name;
	
}
