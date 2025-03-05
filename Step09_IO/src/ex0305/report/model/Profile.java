package ex0305.report.model;

public class Profile {

	private String name;
	private double weight;
	private String password;
	
	
	/*
	 * --------------------------------Getter-Setter ----------------------------------
	 */

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * -------------------------------- Override toString ----------------------------------
	 */
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("님의 몸무게는 ");
		builder.append(weight);
		builder.append("이고 비밀번호는 ");
		builder.append(password);
		builder.append("입니다.");
		return builder.toString();
	}
	
	/*
	 * --------------------------------Constructor ----------------------------------
	 */
	
	public Profile(){
		
	}
	
	public Profile(String name, double weight, String password) {
		super();
		this.name = name;
		this.weight = weight;
		this.password = password;
	}
	
	
	
	
	
	
}
