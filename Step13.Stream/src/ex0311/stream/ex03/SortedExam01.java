package ex0311.stream.ex03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ex0311.stream.Student;

public class SortedExam01 {

	public static void main(String args[]) {

		List<Student> list = Arrays.asList(new Student("�׹���", 22, 60, "��ǻ��"), new Student("�׹���", 22, 80, "����"),
				new Student("����", 22, 70, "��ǻ��"), new Student("������", 22, 50, "����"), new Student("�׹���", 22, 80, "��ǻ��"),
				new Student("���ñ��", 22, 70, "����"));

		list.stream().sorted().forEach(System.out::println);

		list.stream().sorted(Comparator.reverseOrder())
		.forEach(System.out::println);

		list.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge());
		list.stream().sorted((s1, s2) -> s2.getAge() - s1.getAge());
		
		list.stream().sorted(Comparator.comparing(Student::getAge));
		
		
		
		
	}

}
