package ex0310.ConstructorRef;

import java.util.function.Function;

class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("User 이름: " + name);
	}
}

public class ConstructorReferenceWithParams02 {
	public static void main(String[] args) {
		// 기존방식

		Function<String, User> defUser = new Function<String, User>() {
			public User apply(String t) {
				return new User(t);
			}
		};

		// 람다식 방식
		Function<String, User> lambdaUser = name -> new User(name);

		// 생성자 참조 방식
		Function<String, User> constructRefUser = User::new;

		
		
		
		User user0 = defUser.apply("heejung");
		User user1 = lambdaUser.apply("Alice");
		User user2 = constructRefUser.apply("Bob");

		user0.printName(); // User 이름: heejung
		user1.printName(); // User 이름: Alice
		user2.printName(); // User 이름: Bob
	}
}