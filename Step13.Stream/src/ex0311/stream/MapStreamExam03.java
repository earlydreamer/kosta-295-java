package ex0311.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapStreamExam03 {

	private static final double OptionalDouble = 0;

	public static void main (String argsg[]) {
		List<Student> list = Arrays.asList(
				new Student("�׹���",22,60,"��ǻ��"),
				new Student("�׹���",22,80,"����"),
				new Student("����",22,70,"��ǻ��"),
				new Student("������",22,50,"����"),
				new Student("�׹���",22,80,"��ǻ��"),
				new Student("���ñ��",22,70,"����"));
		
		
		//��ü ���
		
		System.out.println(list);
		
		
		
		//������ ���
	
		list.stream().mapToInt(Student::getScore).forEach(System.out::println);	
		
		//����		
		int sum=list.stream().mapToInt(Student::getScore).sum();

		
		//���� ���
		double avg = list.stream().mapToInt(Student::getScore).average().orElse(0.0);
		
		
		//������ 80 �̻��� �л��� �̸�
		
		long count = list.stream().mapToInt(Student::getScore).count();
		System.out.println("�ο���" + count);
		System.out.println("���"+avg );
		
		list.stream().filter(s->s.getScore()>=70).map((s)->s.getName()).forEach(System.out::println);;
 	
		
	}

	
	
}
