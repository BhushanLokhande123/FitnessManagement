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
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int tid;
	
	@Column
	String fullname;
	
	@Column
	double fees;
	
	@Column
	String email;

	@Column
	String speciality;
	
	@Column
	int workexp;
	
	@Column
	String status;
	
	@Column
	String contactno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginid")
	Login loginid;
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Trainer(String fullname, double fees, String email, String speciality, int workexp, String status,
			String contactno, Login loginid) {
		super();
		this.fullname = fullname;
		this.fees = fees;
		this.email = email;
		this.speciality = speciality;
		this.workexp = workexp;
		this.status = status;
		this.contactno = contactno;
		this.loginid = loginid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
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

	public Login getLoginid() {
		return loginid;
	}

	public void setLoginid(Login loginid) {
		this.loginid = loginid;
	}

}