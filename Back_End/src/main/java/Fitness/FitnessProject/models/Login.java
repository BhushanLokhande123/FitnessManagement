package Fitness.FitnessProject.models;


public class Login {
	
	int loginid;
	String username;
	String password;
	String role;
	String email;
	

	public Login(int loginid,String email,String password, String role, String username ) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}
	



	@Override
	public String toString() {
		return "Login [loginid=" + loginid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", email=" + email + "]";
	}


	public Login() {
		super();
	}

	
	public Login(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
