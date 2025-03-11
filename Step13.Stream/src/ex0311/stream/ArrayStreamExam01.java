package ex0311.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String args[]){
		
		//String Array
		System.out.println("-----------------------------------------------");
		
		String[] strArr = {"그뭐냐","있잖아요","뭐시기냐","그거"};
		for(String s : strArr) {System.out.println(s);} //전통적인 방식의 Iterator
		
		//Stream을 이용한 String array..
//		Arrays.stream(strArr).forEach((t)->System.out.println(t));//람다를 이용한 출력
		Arrays.stream(strArr).forEach(System.out::println);//메소드 참조를 통한 출력
		
		Stream <String> stream = Arrays.stream(strArr);
		stream.forEach(System.out::println);
//		stream.forEach(System.out::println);// 재사용 안됨
		
		
		//Int Array 
		System.out.println("-----------------------------------------------");
		int[] intArray = {1,2,3,5,6,7,89,2,4,5,7};
		IntStream.of(intArray).forEach(System.out::print);
		
		//range() vs rangeClosed
		System.out.println("-----------------------------------------------");
		IntStream.range(1, 10).forEach(System.out::println); //1부터 9까지 숫자만 찍는다
		IntStream.rangeClosed(1,10).forEach(System.out::println); //1부터 10 사이에 있는 숫자만 찍는다		

		
	}
}
