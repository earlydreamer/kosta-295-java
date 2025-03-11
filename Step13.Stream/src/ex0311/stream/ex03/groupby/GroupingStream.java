package ex0311.stream.ex03.groupby;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingStream {
	public static void main(String args[]) {

	}

}

public class GroupingByExample {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("����", 22, 88.5, "Computer Science"),
				new Student("����", 24, 76.2, "Mathematics"), 
				new Student("����", 23, 92.3, "Computer Science"),
				new Student("����", 25, 81.7, "Physics"), 
				new Student("����", 21, 85.4, "Mathematics"));
		////////////////////////////////////////////////////////////////////////////////////////// 
		/*
		 * groupingBy(Student::getMajor) �� ����(major) �������� �׷�ȭ ���� ������ ���� �л����� ���� �׷쿡 �����.
		 */
		System.out.println("-----1) �������� �л��� �׷�ȭ----------------------");
		// �������� �л��� �׷�ȭ

		Map<Object, List<Student>> map = students.stream().collect(Collectors.groupingBy((s) -> s.major));

		Map majorCountmap = students.stream().forEach((major, studentList) -> System.out::println);

		System.out.println("������ �л��� Ȯ��...");
		students.stream().collect(Collectors.groupindexingBy(Student::getMajor, Collectors.counting));

		System.out.println(majorCountmap);

		System.out.println(" ������ ���� ���");
		Collection<Student> topStudentByMajor;
		topStudentByMajor.stream().forEach((major, student) -> System.out.println(major + ": " + student.get()));

//		System.out.println(averageMap);

	}
}
