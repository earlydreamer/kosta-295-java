package ex0311.stream.ex03.collect;

public class Student {

	private String name;
	private int age;
	private int score;
	private String gender;

	public Student(String name, int age, String gender,int score) {
		this.name = name;
		this.score = score;
		this.gender = gender;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMajor() {
		return gender;
	}

	public void setMajor(String major) {
		this.gender = major;
	}


}