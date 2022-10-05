package Fitness.FitnessProject.models;

public class Admin {
	
	int aid;
	
	
	String name;
	

	String email;
	
	
	String contactno;
	
	
	int loginid;
	
	
	String status;
	
	public Admin() {
		super();
	}

	public Admin(int aid, String name, String email, String contactno, int loginid, String status) {
		super();
		this.aid = aid;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.loginid = loginid;
		this.status = status;
	}
   
	public Admin(String name, String email, String contactno, String status) {
		super();
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.status = status;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
