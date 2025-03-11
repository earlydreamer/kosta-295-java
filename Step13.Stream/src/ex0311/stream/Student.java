package ex0311.stream;

public class Student {

	private String name;
	private String gender;
	private int age;
	private int score;
	

	public Student(String name, int score, int age, String gender) {
		this.name = name;
		this.gender=gender;
		this.age = age;
		this.score = score;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}