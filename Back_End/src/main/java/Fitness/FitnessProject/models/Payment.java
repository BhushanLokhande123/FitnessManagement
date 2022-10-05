package Fitness.FitnessProject.models;

public class Payment {
	
	int pid;
	
	String name;
	
	double fees;
	
	int loginid;
	
	public Payment(String name, double fees) {
		super();
		this.name = name;
		this.fees = fees;
	}

	public Payment(int pid, double fees,String name, int loginid) {
		super();
		this.pid = pid;
		this.name = name;
		this.fees = fees;
		this.loginid = loginid;
	}

	public Payment() {
		super();
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
    	
}
