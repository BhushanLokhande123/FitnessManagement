package Fitness.FitnessProject.models;

public class MemberRegister
{
	int memid;
  String username;
  String password;
  String fullname;
  String gender;
  double height,weight,chest,waist;
  String injury;
  int contactno;
  String status;
  String email;
  int tid;
  int loginid;
  String role;
  int fees;
  
public int getFees() {
	return fees;
}

public void setFees(int fees) {
	this.fees = fees;
}

public int getLoginid() {
	return loginid;
}

public void setLoginid(int loginid) {
	this.loginid = loginid;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public MemberRegister() {
	super();
}

public MemberRegister(String username, String password, String fullname, String gender, double height, double weight,
		double chest, double waist,String injury, int contactno, String status,String email,int tid) {
	super();
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.chest = chest;
	this.waist = waist;
	this.injury = injury;
	this.contactno = contactno;
	this.status = status;
	this.email = email;
	this.tid=tid;
}

public MemberRegister(int memid, double chest, int contactno, String email,String fullname, String gender, double height,
		 String injury,  String status, int tid,double waist, double weight, int loginid) {
	super();
	this.memid = memid;
	this.fullname = fullname;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.chest = chest;
	this.waist = waist;
	this.injury = injury;
	this.contactno = contactno;
	this.status = status;
	this.email = email;
	this.tid = tid;
	this.loginid = loginid;
}

public MemberRegister(int memid, double chest, int contactno, String email,String fullname, String gender, double height,
		 String injury,  String status, int tid,double waist, double weight, int loginid,String password,String role,String username) {
	super();
	this.memid = memid;
	this.fullname = fullname;
	this.gender = gender;
	this.height = height;
	this.weight = weight;
	this.chest = chest;
	this.waist = waist;
	this.injury = injury;
	this.contactno = contactno;
	this.status = status;
	this.email = email;
	this.tid = tid;
	this.loginid = loginid;
	this.username=username;
	this.password=password;
	this.role=role;
}

public int getMemid() {
	return memid;
}

public void setMemid(int memid) {
	this.memid = memid;
}

public String getInjury() {
	return injury;
}

public void setInjury(String injury) {
	this.injury = injury;
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