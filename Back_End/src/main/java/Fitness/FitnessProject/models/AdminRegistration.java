package Fitness.FitnessProject.models;

public class AdminRegistration {
	int aid;
	String username;
	String password;
	String fullname;
	String email;
	int contactno;
	String status;
	int loginid;
	String role;

	public AdminRegistration(int aid,int contactno,String email, String fullname,int loginid,String status,String password,String role,String username) {
		super();
		this.aid = aid;
		this.fullname = fullname;
		this.email = email;
		this.contactno = contactno;
		this.status = status;
		this.loginid = loginid;
		this.password=password;
		this.role=role;
		this.username=username;
	}

	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public AdminRegistration() {
		super();
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


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
