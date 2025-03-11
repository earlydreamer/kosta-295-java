package ex0311.stream.ex03.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ex0311.stream.ex03.Student;

public class CollectStreamExam04 {
	public static void main (String args[]) {
		List<Student>studentList= new ArrayList<>(); 
		studentList.add(new Student("장희정", "남", 92)); 
		studentList.add(new Student("하승현", "여", 87)); 
		studentList.add(new Student("오문정", "남", 95)); 
		studentList.add(new Student("김은영", "여", 93)); 
		 
		//남학생만 묶어 List 생성 
		/*List<Student>maleList = totalList.stream() 
		             .filter(s->s.getGender().equals("남")) 
		             .collect(Collectors.toList());*/ 
		 
		//Collect 대신 tolist 사용해보기
		
		List<Student>maleList = studentList.stream() 
	             .filter(s->s.getGender().equals("남")) 
	             .toList(); //JAVA 16에서 추가됨
		
		
		List<Student> manList2 = null;
		manList2.add(new Student("김아무개","남",97));
		
		//----toMap 사용해보기 ----------------
		//학생정보 이름을 key, 정수를 value 로 만들자
		Map<String,Integer> map = studentList.stream().collect( Collectors.toMap((s)->s.getName(), (s)->s.getScore()));
		maleList.stream().collect(Collectors.toMap(Student::getName,Student::getName));;
			
		System.out.println(map); 
		
		
		
	}
}
