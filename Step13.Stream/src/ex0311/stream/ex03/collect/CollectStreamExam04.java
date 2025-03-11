package ex0311.stream.ex03.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ex0311.stream.ex03.Student;

public class CollectStreamExam04 {
	public static void main (String args[]) {
		List<Student>studentList= new ArrayList<>(); 
		studentList.add(new Student("������", "��", 92)); 
		studentList.add(new Student("�Ͻ���", "��", 87)); 
		studentList.add(new Student("������", "��", 95)); 
		studentList.add(new Student("������", "��", 93)); 
		 
		//���л��� ���� List ���� 
		/*List<Student>maleList = totalList.stream() 
		             .filter(s->s.getGender().equals("��")) 
		             .collect(Collectors.toList());*/ 
		 
		//Collect ��� tolist ����غ���
		
		List<Student>maleList = studentList.stream() 
	             .filter(s->s.getGender().equals("��")) 
	             .toList(); //JAVA 16���� �߰���
		
		
		List<Student> manList2 = null;
		manList2.add(new Student("��ƹ���","��",97));
		
		//----toMap ����غ��� ----------------
		//�л����� �̸��� key, ������ value �� ������
		Map<String,Integer> map = studentList.stream().collect( Collectors.toMap((s)->s.getName(), (s)->s.getScore()));
		maleList.stream().collect(Collectors.toMap(Student::getName,Student::getName));;
			
		System.out.println(map); 
		
		
		
	}
}
