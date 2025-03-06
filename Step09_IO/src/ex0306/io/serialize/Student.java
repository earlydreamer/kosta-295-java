package ex0306.io.serialize;

import java.io.Serializable;

/**
 * 학생정보 DTO
 * @version 1
 */

public class Student implements Serializable{
	
	//필드만 직렬화 대상이 된다. 생성자, 메소드는 직렬화의 대상이 아니며 static 키워드가 붙어있어도 직렬화가 되지 않는다.
	// Field

	private static final long serialVersionUID = 1l;
	
	private String student;
	private int age;
	private transient String address; //transient 키워드 : 직렬화 대상에서 제외
	
	
	//toString Override
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [student=");
		builder.append(student);
		builder.append(", age=");
		builder.append(age);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
	
	//Getter-Setter
	
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
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
	

	//Constructor
	
	Student(){
		
	}

	
	public Student(String student, int age, String address) {
		super();
		this.student = student;
		this.age = age;
		this.address = address;
	}
	
	
}
