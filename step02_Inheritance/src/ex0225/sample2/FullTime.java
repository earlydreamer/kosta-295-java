package ex0225.sample2;

public class FullTime extends Employee {

	protected int salary;
	protected int bonus;
	
	public FullTime() {
		
	}
	
	
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName=deptName;
		this.salary = salary;
		this.bonus  = bonus;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getEmpNo());
		builder.append(" | ");
		builder.append(geteName());
		builder.append(" | ");
		builder.append(getJob());
		builder.append(" | ");
		builder.append(getMgr());
		builder.append(" | ");
		builder.append(getHiredate());
		builder.append(" | ");
		builder.append(getDeptName());
		builder.append(" | ");
		builder.append(getSalary());
		builder.append(" | ");
		builder.append(getBonus());
		
		return builder.toString();
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




	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println(eName + "사원은 정규직입니다.");
	}

	
	
	
}
