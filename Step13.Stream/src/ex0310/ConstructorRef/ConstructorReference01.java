package ex0310.ConstructorRef;

import java.util.function.Supplier;

class Person {
	public Person() {
		System.out.println("货肺款 Person 按眉 积己!");
	}
}

public class ConstructorReference01 {
	public static void main(String[] args) {
		// 扁粮规侥

		Supplier<Person> beforePerson = new Supplier<Person>() {
			 	
			public Person get() {
				return new Person();
			}
			
		};
		
		
		//Lambda 规侥
		Supplier <Person> lambdaPerson =()->new Person();
		
		
		//积己磊曼炼
		Supplier <Person> constructorPerson = Person::new; //lambda 救俊辑父 悼累茄促...
		
		
		
		Person p1 = beforePerson.get();// 货肺款 Person 按眉 积己
		Person p2 = lambdaPerson.get(); // 货肺款 Person 按眉 积己
		Person p3 = constructorPerson.get(); // 货肺款 Person 按眉 积己
	}
}