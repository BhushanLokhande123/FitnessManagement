package com.example.demo.entities;

public class MemberRegister
{
  String username;
  String password;
  String fullname;
  String gender;
  double height,weight,chest,waist;
  String contactno;
  String status;
  String email;
  int tid;
  
public MemberRegister() {
	super();
	// TODO Auto-generated constructor stub
}

public MemberRegister(String username, String password, String fullname, String gender, double height, double weight,
		double chest, double waist, String contactno, String status,String email,int tid) {
	super();
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.chest = chest;
	this.waist = waist;
	this.contactno = contactno;
	this.status = status;
	this.email = email;
	this.tid=tid;
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

public int getTid() {
	return tid;
}

public void setTid(int tid) {
	this.tid = tid;
}


  
  
}