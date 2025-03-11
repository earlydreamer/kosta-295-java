package ex0311.stream.ex03.groupby;

public class Student {

	private String name;
	private String gender;
	private int age;
	private double score;
	public String major;
	

	public Student(String name, int i, double d, String string) {
		this.name = name;
		this.age=i;
		this.score = d;
		this.major = string;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}