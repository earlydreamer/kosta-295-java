package ex0311.stream.ex03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ex0311.stream.Student;

public class SortedExam01 {

	public static void main(String args[]) {

		List<Student> list = Arrays.asList(new Student("그뭐냐", 22, 60, "컴퓨터"), new Student("그뭐냐", 22, 80, "영어"),
				new Student("뭐냐", 22, 70, "컴퓨터"), new Student("뭐더라", 22, 50, "수학"), new Student("그뭐냐", 22, 80, "컴퓨터"),
				new Student("뭐시기냐", 22, 70, "과학"));

		list.stream().sorted().forEach(System.out::println);

		list.stream().sorted(Comparator.reverseOrder())
		.forEach(System.out::println);

		list.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge());
		list.stream().sorted((s1, s2) -> s2.getAge() - s1.getAge());
		
		list.stream().sorted(Comparator.comparing(Student::getAge));
		
		
		
		
	}

}
