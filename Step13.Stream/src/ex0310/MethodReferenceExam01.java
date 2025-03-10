package ex0310;

import java.util.function.Function;

class Utils {
	public static int square(int x) {
		return x * x;
	}
}

public class MethodReferenceExam01 {
    public static void main(String[] args) { 
        //기존방식 
        Function<Integer, Integer>  beforeSquare =  new Function<Integer, Integer>() { 
     @Override 
     public Integer apply(Integer t) { 
       return Utils.square(t); 
           } 
    }; 
		
		//람다 방식
		Function<Integer,Integer> lambdaSquare = (t) -> Utils.square(t);
		
		//Static 메소드 참조 문법 : 람다를 간결화
		//람다 안에서만 쓸수있다
		Function<Integer,Integer> methodRefSquare = Utils::square; //이 자리에는 무조건 apply가 있고, 숫자가 그 자리에 있다는 사실이 묵시적으로 적용
		
		System.out.println(beforeSquare.apply(5));
		System.out.println(lambdaSquare.apply(5));
		System.out.println(methodRefSquare.apply(5));
				
	}
}


