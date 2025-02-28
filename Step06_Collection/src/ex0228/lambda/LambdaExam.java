package ex0228.lambda;



public class LambdaExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//----- 전통적인 방식의 호출 ---------------------
//		TestInterfaceA test =  new TestClass();
//		test.test(); //기존 방식의 호출
	
		//------ 익명 Inner Class 방식의 구현 -------------
//		TestInterfaceA test = new TestInterfaceA() { //인터페이스를 사용하는 1회용 익명 InnerClass를 생성
//			
//			@Override
//			public void test() {//Test 메소드의 동작을 Override
//				// TODO Auto-generated method stub
//				System.out.println("Inner Class 구현...");
//			}
//		}; 
//		test.test();
//		
		//---- Lambda식을 이용한 방법 ----------------------
		//@FunctionalInterface로 되어있을 경우만 가능하다
		//Lambda식을 통한 구현은 FunctionalInterface 내의 유일한 메소드를 단축구현하는 익명 이다.
		//Java8에 람다식과 같이 static / default 메소드의 구현체가 추가됨 -> lambda식은 해당 동작과 같은가 ???
		//비슷해 보이는데 아니었다 둘이 조금 원리가 다르다... 
		//Lambda식을 이용한 구현은 블록 안의 내용으로 오버라이드된 익명 클래스 객체를 선언해 구현되는것
		//인터페이스 바디는 static 혹은 default 스코프 내에서 자동으로 오버라이드되어 동작되는 것으로 해당하는 구현체가 따로 있다는 점에서 다르다...
		
		TestInterfaceA test = ()-> System.out.println("Lambda식을 이용한 한줄 동작"); ; 		
		test.test();
				
		TestInterfaceB test2 = (i) -> {
			System.out.println("Lambda식을 통한 동작 -> (int i) -> " + i);
		};
		
		test2.testB(5);
		
//		TestInterfaceC test3 = (i,j) ->	return i+j; // 한 줄로 표현할 때는 return을 붙이면 안 된다.
		TestInterfaceC test3 = (i,j) ->{
			System.out.print("lambda식을 통한 동작 -> 다음을 리턴 : ");
			return i+j;
		};
		
		System.out.println(test3.testC(1, 2));
	
	}

}

class TestClass implements TestInterfaceA{
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("test");
	}
	
}