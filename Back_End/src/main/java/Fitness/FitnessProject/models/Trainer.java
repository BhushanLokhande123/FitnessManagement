package Fitness.FitnessProject.models;

public class Trainer {


	int tid;
	
	
	String fullname;
	
	
	double fees;
	
	
	String email;

	
	String speciality;
	
	
	int workexp;
	
	
	String status;
	
	
	String contactno;
	
	
	Login loginid;
	
	public Trainer() {
		super();
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