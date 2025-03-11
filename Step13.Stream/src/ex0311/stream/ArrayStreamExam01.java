package ex0311.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String args[]){
		
		//String Array
		System.out.println("-----------------------------------------------");
		
		String[] strArr = {"�׹���","���ݾƿ�","���ñ��","�װ�"};
		for(String s : strArr) {System.out.println(s);} //�������� ����� Iterator
		
		//Stream�� �̿��� String array..
//		Arrays.stream(strArr).forEach((t)->System.out.println(t));//���ٸ� �̿��� ���
		Arrays.stream(strArr).forEach(System.out::println);//�޼ҵ� ������ ���� ���
		
		Stream <String> stream = Arrays.stream(strArr);
		stream.forEach(System.out::println);
//		stream.forEach(System.out::println);// ���� �ȵ�
		
		
		//Int Array 
		System.out.println("-----------------------------------------------");
		int[] intArray = {1,2,3,5,6,7,89,2,4,5,7};
		IntStream.of(intArray).forEach(System.out::print);
		
		//range() vs rangeClosed
		System.out.println("-----------------------------------------------");
		IntStream.range(1, 10).forEach(System.out::println); //1���� 9���� ���ڸ� ��´�
		IntStream.rangeClosed(1,10).forEach(System.out::println); //1���� 10 ���̿� �ִ� ���ڸ� ��´�		

		
	}
}
