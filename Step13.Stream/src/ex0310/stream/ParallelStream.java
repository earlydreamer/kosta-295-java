package ex0310.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie"); 
//		
//		for (String name : names) { 
//		    if (name.startsWith("C")) { 
//		        System.out.println(Thread.currentThread().getName() + " - " + name); 
//		    } 
//		} 
		names.parallelStream() 
	     .filter(name -> name.startsWith("C")) 
	     .forEach(name ->  
	         System.out.println(Thread.currentThread().getName() + " - " + name) 
	     );
	}
}


//
