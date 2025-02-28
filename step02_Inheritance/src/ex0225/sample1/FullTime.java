package ex0225.sample1;

public class FullTime {

	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int salary;
	private int bonus;
	
	public void message() {
		System.out.println(eName + "사원은 정규직입니다.");
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(empNo);
		builder.append("| ");
		builder.append(eName);
		builder.append("| ");
		builder.append(job);
		builder.append("| ");
		builder.append(mgr);
		builder.append("| ");
		builder.append(hiredate);
		builder.append("| ");
		builder.append(deptName);
		builder.append("| ");
		builder.append(salary);
		builder.append("| ");
		builder.append(bonus);
		return builder.toString();
	}




	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getMgr() {
		return mgr;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	FullTime(){
		
	}


	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}


	
	
}
