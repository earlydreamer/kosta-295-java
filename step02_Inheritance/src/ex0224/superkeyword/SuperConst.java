package ex0224.superkeyword;


class SuperClass{
//	SuperClass(){
//	System.out.println("1");	
//	}
	
	SuperClass(int i){
		System.out.println("2");	
	}

	SuperClass(String s){
		System.out.println("3");
	}
}


class ChildClass extends SuperClass{
	
	ChildClass(){
//		super(); // super 키워드 생략
		super(1); //super의 2번생성자 (int i) 를 명시적으로 호출
		System.out.println("4");
	}
	ChildClass(int a){
//		super();
		this(); // this를 불러도 무방함
		System.out.println("5");
	}
	ChildClass(boolean b){
//		super();
		this(1); //this의 파라미터를 받는 생성자를 호출해도 컴파일은 됨 
		System.out.println("6");
	}
	
	
}


public class SuperConst {

	public static void main(String[] args) {
		
		
//		new ChildClass();
//		new ChildClass(6);
		new ChildClass(true); 
//		new SuperClass();

		//자식생성자 구현부 첫번째줄에 Super(); 생략되어있음
		//자식이 인수가 있는 생성자를 호출해도 호출되는 것은 부모의 디폴트 생성자인 super(); 

		//만약 1,2,3이 없다면 ... 디폴트 생성자가 자동으로 생성됨
		//2,3이 있는데 1이 없다면 에러남 (디폴트 생성자가 ㅇ벗기 때문)
		// 디폴트 생성자가 없을 경우 명시적으로 다른 생성자를 첫줄에 불러주어야 함 (super 생성자가 아니어도 무관함)
		
		
		
		
		
		

	}

}
