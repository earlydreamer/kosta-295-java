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
				new Student("희정", 22, 88.5, "Computer Science"),
				new Student("찬범", 24, 76.2, "Mathematics"), 
				new Student("가현", 23, 92.3, "Computer Science"),
				new Student("현솔", 25, 81.7, "Physics"), 
				new Student("현준", 21, 85.4, "Mathematics"));
		////////////////////////////////////////////////////////////////////////////////////////// 
		/*
		 * groupingBy(Student::getMajor) → 전공(major) 기준으로 그룹화 같은 전공을 가진 학생들이 같은 그룹에 저장됨.
		 */
		System.out.println("-----1) 전공별로 학생을 그룹화----------------------");
		// 전공별로 학생을 그룹화

		Map<Object, List<Student>> map = students.stream().collect(Collectors.groupingBy((s) -> s.major));

		Map majorCountmap = students.stream().forEach((major, studentList) -> System.out::println);

		System.out.println("전공별 학생수 확인...");
		students.stream().collect(Collectors.groupindexingBy(Student::getMajor, Collectors.counting));

		System.out.println(majorCountmap);

		System.out.println(" 전공별 점수 평균");
		Collection<Student> topStudentByMajor;
		topStudentByMajor.stream().forEach((major, student) -> System.out.println(major + ": " + student.get()));

//		System.out.println(averageMap);

	}
}
