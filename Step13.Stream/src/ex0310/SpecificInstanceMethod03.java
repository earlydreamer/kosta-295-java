package ex0310;

import java.util.function.BiFunction;

public class SpecificInstanceMethod03 {
	public static void main(String[] args) {

		
		// �������
		
		BiFunction<String, String, Boolean> beforeEquals = new BiFunction<>() {
			public Boolean apply(String s1, String s2) {
				return s1.equals(s2);
			}
		};
		
		//���ٽ�
		BiFunction<String, String, Boolean> lambdaEquals = (s1, s2) -> s1.equals(s2);
		
		//�޼ҵ� ����
		BiFunction<String, String, Boolean>methodRefEquals = String::equals;
		
		

		System.out.println(beforeEquals.apply("heejung", "heejung")); // true
		System.out.println(lambdaEquals.apply("Java", "Java")); // true
		System.out.println(methodRefEquals.apply("Java", "Python")); // false
	}
}