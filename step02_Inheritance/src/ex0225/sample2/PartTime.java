package ex0225.sample2;

public class PartTime extends Employee {

	protected int timePay;

	public PartTime() {
		
	}

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName=deptName;
		this.timePay = timePay;
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
		builder.append(timePay);

		return builder.toString();
	}

	public int getTimePay() {
		return timePay;
	}


	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}


	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println(eName + "사원은 비정규직입니다.");
		
	}

}
