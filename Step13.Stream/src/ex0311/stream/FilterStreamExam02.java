package ex0311.stream;

import java.util.Arrays;
import java.util.List;

public class FilterStreamExam02 {

	public static void main(String args[]) {
		List<String> list = Arrays.asList("�׹���","��","������","������","������","���ñ��","��","�׹���");
		System.out.println("-------------�ߺ�������--------------");
		long count = list.stream().distinct().count();//
		System.out.println(count);
		
		list.stream().distinct().forEach(System.out::println);
		
		
		System.out.println("-------------Filter ��� �ɷ�����--------------");
		
		list.stream().filter((s)->s.equals("������")).forEach(System.out::println);
		
		list.stream().filter((s)->s.startsWith("��")).forEach(System.out::println);

		list.stream().filter((s)->s.startsWith("��")).distinct().forEach(System.out::println);
		
	}
	
}
