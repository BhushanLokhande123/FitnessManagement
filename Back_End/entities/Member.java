package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member 
{
	public Member(String fullname, double height, double weight, double chest, double waist, String contactno,
			int tid) {
		super();
		this.fullname = fullname;
		this.height = height;
		this.weight = weight;
		this.chest = chest;
		this.waist = waist;
		this.contactno = contactno;
		this.tid = tid;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int memid;
	
	@Column
	String fullname;
	
	@Column
	String gender;
	
	@Column
	double height;
	
	@Column
	double weight;
	
	@Column
	double chest;
	
	@Column
	double waist;
	
	@Column
	String contactno;
	
	@Column
	String status;
	
	@Column
	String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginid")
	Login loginid;
	
	
	@Column(nullable=true)
	int tid;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Member( String fullname, String gender, double height, double weight, double chest, double waist,
			String contactno, String status, String email, Login loginid,int tid) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.chest = chest;
		this.waist = waist;
		this.contactno = contactno;
		this.status = status;
		this.email = email;
		this.loginid = loginid;
		this.tid=tid;
		
	}

	public int getMemid() {
		return memid;
	}

	public void setMemid(int memid) {
		this.memid = memid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getChest() {
		return chest;
	}

	public void setChest(double chest) {
		this.chest = chest;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLoginid() {
		return loginid;
	}

	public void setLoginid(Login loginid) {
		this.loginid = loginid;
	}



	public int getTid() {
		return tid;
	}



	public void setTid(int tid) {
		this.tid = tid;
	}

	
	
}