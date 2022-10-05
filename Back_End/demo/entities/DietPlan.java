package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dietplan")
public class DietPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int dpid;
	
	@Column
	String fooditem;
	
	@Column
	String time;
	
	@Column
	String category;

	public DietPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DietPlan( String fooditem, String time, String category) {
		super();
		this.fooditem = fooditem;
		this.time = time;
		this.category = category;
	}

	public int getDpid() {
		return dpid;
	}

	public void setDpid(int dpid) {
		this.dpid = dpid;
	}

	public String getFooditem() {
		return fooditem;
	}

	public void setFooditem(String fooditem) {
		this.fooditem = fooditem;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
