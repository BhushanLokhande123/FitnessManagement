package Fitness.FitnessProject.models;

public class TrainerRegister {
    int tid;
	String username;
	String password;
	String fullname;
	Double fees;
	String email;
	String speciality;
	int workexp;
	String status;
	int contactno;
	String role;
	int loginid;

	public TrainerRegister(int tid,int contactno, String email, Double fees, String fullname, String speciality,String status,  int workexp,
			 int loginid) {
		super();
		this.tid = tid;
		this.fullname = fullname;
		this.fees = fees;
		this.email = email;
		this.speciality = speciality;
		this.workexp = workexp;
		this.status = status;
		this.contactno = contactno;
		this.loginid = loginid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public TrainerRegister() {
		super();
	}
	
	public TrainerRegister(int tid,int contactno,  String email, Double fees,String fullname, String speciality, 
			String status, int workexp, int loginid,String password,String role,String username) {
		super();
		this.tid = tid;
		this.fullname = fullname;
		this.fees = fees;
		this.email = email;
		this.speciality = speciality;
		this.workexp = workexp;
		this.status = status;
		this.contactno = contactno;
		this.loginid = loginid;
		this.password= password;
		this.role=role;
		this.username=username;
	}



	public TrainerRegister(String username, String password, String fullname, Double fees, String email,
			String speciality, int workexp, String status, int contactno) {
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
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	
	
}
