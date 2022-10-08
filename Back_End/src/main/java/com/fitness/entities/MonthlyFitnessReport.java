package com.fitness.entities;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "monthly_fitness_report")
public class MonthlyFitnessReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="report_id")
	private Integer reportId;
	
	@Enumerated(EnumType.STRING)
	private Month month;
	
	@Column(name="start_date" , nullable = false)
	private LocalDate startDate;
	
	@Column(name="end_date" , nullable = false)
	private LocalDate endDate;
	
	private double fat;
	
	private double weight;
	
	private double muscle;
	
	private double height;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userRecord;
	
}
