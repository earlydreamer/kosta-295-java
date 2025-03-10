package ex0310.ConstructorRef;

import java.util.function.Function;

class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("User �̸�: " + name);
	}
}

public class ConstructorReferenceWithParams02 {
	public static void main(String[] args) {
		// �������

		Function<String, User> defUser = new Function<String, User>() {
			public User apply(String t) {
				return new User(t);
			}
		};

		// ���ٽ� ���
		Function<String, User> lambdaUser = name -> new User(name);

		// ������ ���� ���
		Function<String, User> constructRefUser = User::new;

		
		
		
		User user0 = defUser.apply("heejung");
		User user1 = lambdaUser.apply("Alice");
		User user2 = constructRefUser.apply("Bob");

		user0.printName(); // User �̸�: heejung
		user1.printName(); // User �̸�: Alice
		user2.printName(); // User �̸�: Bob
	}
}