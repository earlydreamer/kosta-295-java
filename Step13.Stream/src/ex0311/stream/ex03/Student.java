package ex0311.stream.ex03;

public class Student {

	private String name;
	private int age;
	private int score;
	private String major;

	public Student(String name, int age, int score, String major) {
		this.name = name;
		this.age = age;
		this.score = score;
		this.major = major;
	}

	public Student(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
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
		return major;
	}

	public void setGender(String major) {
		this.major = major;
	}

	public Object getGender() {
		// TODO Auto-generated method stub
		return null;
	}


}