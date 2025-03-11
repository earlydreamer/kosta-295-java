package ex0311.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapStreamExam03 {

	private static final double OptionalDouble = 0;

	public static void main (String argsg[]) {
		List<Student> list = Arrays.asList(
				new Student("그뭐냐",22,60,"컴퓨터"),
				new Student("그뭐냐",22,80,"영어"),
				new Student("뭐냐",22,70,"컴퓨터"),
				new Student("뭐더라",22,50,"수학"),
				new Student("그뭐냐",22,80,"컴퓨터"),
				new Student("뭐시기냐",22,70,"과학"));
		
		
		//전체 출력
		
		System.out.println(list);
		
		
		
		//점수만 출력
	
		list.stream().mapToInt(Student::getScore).forEach(System.out::println);	
		
		//총점		
		int sum=list.stream().mapToInt(Student::getScore).sum();

		
		//점수 평균
		double avg = list.stream().mapToInt(Student::getScore).average().orElse(0.0);
		
		
		//점수가 80 이상인 학생의 이름
		
		long count = list.stream().mapToInt(Student::getScore).count();
		System.out.println("인원수" + count);
		System.out.println("평균"+avg );
		
		list.stream().filter(s->s.getScore()>=70).map((s)->s.getName()).forEach(System.out::println);;
 	
		
	}

	
	
}
