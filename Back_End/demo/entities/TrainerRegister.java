package com.example.demo.entities;

public class TrainerRegister {

	String username;
	String password;
	String fullname;
	Double fees;
	String email;
	String speciality;
	int workexp;
	String status;
	String contactno;
	public TrainerRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainerRegister(String username, String password, String fullname, Double fees, String email,
			String speciality, int workexp, String status, String contactno) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.fees = fees;
		this.email = email;
		this.speciality = speciality;
		this.workexp = workexp;
		this.status = status;
		this.contactno = contactno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getWorkexp() {
		return workexp;
	}
	public void setWorkexp(int workexp) {
		this.workexp = workexp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	
}
