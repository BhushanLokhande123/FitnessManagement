package Fitness.FitnessProject.models;

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



	
	int memid;
	
	
	String fullname;
	

	String gender;
	
	
	double height;
	
	
	double weight;
	
	
	double chest;
	
	
	double waist;
	
	
	String contactno;
	
	
	String status;
	
	
	String injury;
	
	
	String email;
	
	
	Login loginid;
	
	
	int tid;

	public Member() {
		super();
	}

	

	public Member( String fullname, String gender, double height, double weight, double chest, double waist,
			String injury,String contactno, String status, String email, Login loginid,int tid) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.chest = chest;
		this.waist = waist;
		this.injury=injury;
		this.contactno = contactno;
		this.status = status;
		this.email = email;
		this.loginid = loginid;
		this.tid=tid;
		
	}

	public String getInjury() {
		return injury;
	}



	public void setInjury(String injury) {
		this.injury = injury;
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