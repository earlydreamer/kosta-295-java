package ex0228.set;

public class Member {

	private String name;
	private int age;
	private String address;

	Member() {

	}

	public Member(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Member [name=");
//		builder.append(name);
//		builder.append(", age=");
//		builder.append(age);
//		builder.append(", address=");
//		builder.append(address);
//		builder.append("]");
//		return builder.toString();
//	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		// 모든 객체는 Object에 선언된 hashCode()를 상속받는다
		// hashcode를 통해 만들어진 숫자를 통해 1차적으로 비교한다.
		System.out.println("hashcode call..." + name.hashCode());
		return name.hashCode() + age;
		// return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// hashcode() 처리 후 한번 더 비교하는 용도이다...
		System.out.println("Equals call...");
		if (obj instanceof Member m) {
			if (this.name.equals(m.getName()) && this.age == m.getAge()) {
				return true;
			}
		}
		return false;
//		return super.equals(obj);
	}
}
