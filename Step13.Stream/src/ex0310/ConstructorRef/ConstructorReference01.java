package ex0310.ConstructorRef;

import java.util.function.Supplier;

class Person {
	public Person() {
		System.out.println("���ο� Person ��ü ����!");
	}
}

public class ConstructorReference01 {
	public static void main(String[] args) {
		// �������

		Supplier<Person> beforePerson = new Supplier<Person>() {
			 	
			public Person get() {
				return new Person();
			}
			
		};
		
		
		//Lambda ���
		Supplier <Person> lambdaPerson =()->new Person();
		
		
		//����������
		Supplier <Person> constructorPerson = Person::new; //lambda �ȿ����� �����Ѵ�...
		
		
		
		Person p1 = beforePerson.get();// ���ο� Person ��ü ����
		Person p2 = lambdaPerson.get(); // ���ο� Person ��ü ����
		Person p3 = constructorPerson.get(); // ���ο� Person ��ü ����
	}
}