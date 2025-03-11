package ex0311.stream;

import java.util.Arrays;
import java.util.List;

public class FilterStreamExam02 {

	public static void main(String args[]) {
		List<String> list = Arrays.asList("±×¹¹³Ä","¾î","¹¹´õ¶ó","¹¹¿´Áö","¹¹´õ¶ó","¹¹½Ã±â³Ä","±×","±×¹¹³Ä");
		System.out.println("-------------Áßº¹ÇàÁ¦°Å--------------");
		long count = list.stream().distinct().count();//
		System.out.println(count);
		
		list.stream().distinct().forEach(System.out::println);
		
		
		System.out.println("-------------Filter ¿ä¼Ò °É·¯³»±â--------------");
		
		list.stream().filter((s)->s.equals("¹¹´õ¶ó")).forEach(System.out::println);
		
		list.stream().filter((s)->s.startsWith("¹¹")).forEach(System.out::println);

		list.stream().filter((s)->s.startsWith("±×")).distinct().forEach(System.out::println);
		
	}
	
}
