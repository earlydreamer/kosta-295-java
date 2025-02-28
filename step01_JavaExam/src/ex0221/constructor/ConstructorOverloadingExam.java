package ex0221.constructor;
class Puppy3{
	/*String 타입 전역 변수 선언
	  int 타입 전역 변수 선언*/
	String puppyName;
	int puppyAge;	

	
	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/
	
	public Puppy3() {
		puppyName = "메리";
		System.out.println("public puppy3()호출되었습니다");
		printMemberVariable();
	}
	
	
	/*String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/	
	public Puppy3(String param1) {
		puppyName = param1;
		System.out.println(puppyName);
		System.out.println("public Puppy3() 호출되었습니다");
		printMemberVariable();
		
	}
		
	
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"출력
	*/
	public Puppy3(String param1, String param2) {
		this(param1 + param2);
		System.out.println("public Puppy3() 호출되었습니다");
	}
		
	
	
	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"  출력
	*/					
	public Puppy3(boolean param1) {
		this(param1+"쫑");
		System.out.println("public Puppy3()호출되었습니다");
	}
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"puplic Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/			
	public Puppy3(char param1) {
		this();
		puppyAge = (int)param1;
		System.out.println("public Puppy()호출되었습니다");
		System.out.println(puppyAge);
	}
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/
	public void printMemberVariable() {
		System.out.println(puppyName);
		System.out.println(puppyAge);
	}
		

	
}

public class ConstructorOverloadingExam{
		//메인메소드에서
		public static void main(String [] args){
			//Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
			System.out.println("---");
			Puppy3 p1 = new Puppy3();
			System.out.println("---");
			Puppy3 p2 = new Puppy3("d");
			System.out.println("---");
			Puppy3 p3 = new Puppy3("111","222");
			System.out.println("---");
			Puppy3 p4 = new Puppy3(false);
			System.out.println("---");
			Puppy3 p5 = new Puppy3('C');
			
			System.out.println("---");
			
			p1.printMemberVariable();
			System.out.println("---");
			p2.printMemberVariable();
			System.out.println("---");
			p3.printMemberVariable();
			System.out.println("---");
			p4.printMemberVariable();
			System.out.println("---");
			p5.printMemberVariable();
			
		//각 객체의 printMemberVariable메소드를 한번씩 호출
			
	}
}