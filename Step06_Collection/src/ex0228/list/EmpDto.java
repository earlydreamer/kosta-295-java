package ex0228.list;

import java.util.Comparator;

/**
 * 사원의 정보를 저장하는 객체
 */
public class EmpDto implements Comparable<EmpDto>, Comparator<EmpDto>{ //Comparable을 Implements 하지 않으면 정렬이 동작하지 않는다...

	private int empNumber;
	private String empName;
	private int age;
	private String address;
	
	EmpDto(){
		
	}
	
	public EmpDto(int empNumber, String empName, int age, String address) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.age = age;
		this.address = address;
	}

	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmpDto [empNumber=" + empNumber + ", empName=" + empName + ", age=" + age + ", address=" + address
				+ "]\n";
	}
	 

	@Override
	public int compareTo(EmpDto o) {
		// TODO Auto-generated method stub
		System.out.println("compare");
		return o.getEmpNumber()-empNumber;
	}

	@Override
	public int compare(EmpDto o1, EmpDto o2) {
		// TODO Auto-generated method stub
		
		
		return 0;
	}
	
}
